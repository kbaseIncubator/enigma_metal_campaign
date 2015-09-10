package us.kbase.kbaseenigmametals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import us.kbase.common.service.Tuple2;
import us.kbase.common.service.UObject;

public class WellSampleMatrixUploader {

	static Options options = new Options();

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		WellSampleMatrixUploader uploader = new WellSampleMatrixUploader();
		uploader.upload(args);
	}

	public WellSampleMatrixUploader() {

		OptionBuilder.withLongOpt("help");
		OptionBuilder.withDescription("print this message");
		OptionBuilder.withArgName("help");
		options.addOption(OptionBuilder.create("h"));

		OptionBuilder.withLongOpt("test");
		OptionBuilder
				.withDescription("This option is for testing only. Program will exit without any output.");
		OptionBuilder.withArgName("test");
		options.addOption(OptionBuilder.create("t"));

		OptionBuilder.withLongOpt("workspace_service_url");
		OptionBuilder.withDescription("Workspace service URL");
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("workspace_service_url");
		options.addOption(OptionBuilder.create("ws"));

		OptionBuilder.withLongOpt("workspace_name");
		OptionBuilder.withDescription("Workspace name");
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("workspace_name");
		options.addOption(OptionBuilder.create("wn"));

		OptionBuilder.withLongOpt("object_name");
		OptionBuilder.withDescription("Object name");
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("object_name");
		options.addOption(OptionBuilder.create("on"));

		OptionBuilder.withLongOpt("input_directory");
		OptionBuilder.withDescription("Input directory");
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("input_directory");
		options.addOption(OptionBuilder.create("id"));

		OptionBuilder.withLongOpt("working_directory");
		OptionBuilder.withDescription("Working directory");
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("working_directory");
		options.addOption(OptionBuilder.create("wd"));

		OptionBuilder.withLongOpt("output_file_name");
		OptionBuilder.withDescription("Output file name");
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("output_file_name");
		options.addOption(OptionBuilder.create("of"));

		OptionBuilder.withLongOpt("input_mapping");
		OptionBuilder.withDescription("Input mapping");
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("input_mapping");
		options.addOption(OptionBuilder.create("im"));

		OptionBuilder.withLongOpt("format_type");
		OptionBuilder.withDescription("Format type");
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("format_type");
		options.addOption(OptionBuilder.create("ft"));

	}

	public void upload(String[] args) throws Exception {
		CommandLineParser parser = new GnuParser();

		try {
			// parse the command line arguments
			CommandLine line = parser.parse(options, args);
			if (line.hasOption("help")) {
				// automatically generate the help statement
				HelpFormatter formatter = new HelpFormatter();
				formatter
						.printHelp(
								"java -jar /kb/deployment/lib/jars/kbase/enigma_metals/kbase-enigma-metals-0.1.jar [parameters]",
								options);

			} else if (line.hasOption("test")) {
				// return nothing and exit
				System.exit(0);
			} else {

				if (validateInput(line)) {

					File inputFile = findTabFile(new File(
							line.getOptionValue("id")));

					WellSampleMatrix matrix = new WellSampleMatrix();
					matrix.setName(line.getOptionValue("on"));
					
					matrix = generateWellSampleMatrix(inputFile, matrix);

					// System.out.println(matrix.toString());
					String outputFileName = line.getOptionValue("of");
			        if (outputFileName == null)
			            outputFileName = "matrix_output.json";

			        String workDirName = line.getOptionValue("wd");
			        if (workDirName == null)
			            workDirName = (".");
			        File workDir = new File(workDirName);
			        if (!workDir.exists())
			            workDir.mkdirs();
			        File outputFile = new File(workDir, outputFileName);
			        UObject.getMapper().writeValue(outputFile, matrix);

				} else {
					HelpFormatter formatter = new HelpFormatter();
					formatter
							.printHelp(
									"java -jar /kb/deployment/lib/jars/kbase/enigma_metals/kbase-enigma-metals-0.1.jar [parameters]",
									options);
					System.exit(1);
				}
			}

		} catch (ParseException exp) {
			// oops, something went wrong
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
		}

	}

	public WellSampleMatrix generateWellSampleMatrix(File inputFile, WellSampleMatrix matrix)
			throws Exception {

		List<String> data = new ArrayList<String>();
		List<String> columnMetaData = new ArrayList<String>();
		List<String> rowMetaData = new ArrayList<String>();

		try {
			String line = null;
			boolean colMetaDataFlag = false;
			boolean rowMetaDataFlag = false;
			boolean dataFlag = false;
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			while ((line = br.readLine()) != null) {
				if (line.equals("")) {
					// do nothing on blank lines
				} else if (line.matches("DATA\t.*")) {
					dataFlag = true;
					colMetaDataFlag = false;
					rowMetaDataFlag = false;
					data.add(line);
				} else if (line.matches("COLUMN_METADATA\tType\tName\tUnit\tValue.*")) {
					dataFlag = false;
					colMetaDataFlag = true;
					rowMetaDataFlag = false;
				} else if (line.matches("ROW_METADATA\tType\tName\tUnit\tValue.*")) {
					dataFlag = false;
					colMetaDataFlag = false;
					rowMetaDataFlag = true;
				} else {
					if (dataFlag && !colMetaDataFlag && !rowMetaDataFlag) {
						data.add(line);
					} else if (!dataFlag && colMetaDataFlag && !rowMetaDataFlag) {
						columnMetaData.add(line);
					} else if (!dataFlag && !colMetaDataFlag && rowMetaDataFlag) {
						rowMetaData.add(line);
					} else {
						System.out.println("Warning: string will be missed "
								+ line);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		matrix.setData(DataMatrixUploader.parseData(data));

		matrix.setMetadata(parseWellSampleMetadata(columnMetaData, rowMetaData, matrix.getData().getColIds(), matrix.getData().getRowIds()));
		
		
		if (matrix.getMetadata().getSeriesProperties().containsKey("Description")) {
			matrix.setDescription(matrix.getMetadata().getSeriesProperties().get("Description"));
		} else {
			matrix.setDescription("");
		}

		return matrix;
	}


	private SeriesMetadata parseWellSampleMetadata (List<String> columnMetaData, List<String> rowMetaData, List<String> sampleNames, List<String> rowNames) {
		
		SeriesMetadata returnVal = DataMatrixUploader.parseMetadata(columnMetaData, rowMetaData, sampleNames, rowNames);
		
		Map<String,String> units = new HashMap<String, String>();
		
		for (Tuple2<String, MetadataItem> tuple: returnVal.getRowMetadata()){
			String key = tuple.getE2().getType() + tuple.getE2().getName();
			if (units.containsKey(key)) {
				if (!units.get(key).equals(tuple.getE2().getValueUnit())) {
					System.err.println("Well sample matrix upload failed: Row metadata " + tuple.getE2().getType() + " parameter for " + tuple.getE2().getName() + " has two kinds of unit: " + units.get(key) + " and " + tuple.getE2().getValueUnit());
					System.exit(1);
				}
			} else {
				units.put(key, tuple.getE2().getValueUnit());
			}
		}
		
		for (Tuple2<String, MetadataItem> tuple: returnVal.getColumnMetadata()){
			String key = tuple.getE2().getType() + tuple.getE2().getName();
			if (units.containsKey(key)) {
				if (!units.get(key).equals(tuple.getE2().getValueUnit())) {
					System.err.println("Well sample matrix upload failed: Column metadata " + tuple.getE2().getType() + " parameter for " + tuple.getE2().getName() + " has two kinds of unit: " + units.get(key) + " and " + tuple.getE2().getValueUnit());
					System.exit(1);
				}
			} else {
				units.put(key, tuple.getE2().getValueUnit());
			}
		}

		return returnVal;
	};
	

	private static boolean validateInput(CommandLine line) {
		boolean returnVal = true;
		if (!line.hasOption("ws")) {
			System.err.println("Workspace service URL required");
			returnVal = false;
		}

		if (!line.hasOption("wn")) {
			System.err.println("Workspace ID required");
			returnVal = false;
		}

		if (!line.hasOption("on")) {
			System.err.println("Object name required");
			returnVal = false;
		}

		if (!line.hasOption("id")) {
			System.err.println("Input directory required");
			returnVal = false;
		}

		if (!line.hasOption("wd")) {
			System.err.println("Working directory required");
			returnVal = false;
		}

		return returnVal;
	}

	public static File findTabFile(File inputDir) {
		File inputFile = null;
		StringBuilder fileList = new StringBuilder();
		for (File f : inputDir.listFiles()) {
			if (!f.isFile())
				continue;
			String fileName = f.getName().toLowerCase();
			if (fileName.endsWith(".txt") || fileName.endsWith(".tsv")
					|| fileName.endsWith(".csv") || fileName.endsWith(".tab")) {
				inputFile = f;
				break;
			}
			if (fileList.length() > 0)
				fileList.append(", ");
			fileList.append(f.getName());
		}
		if (inputFile == null)
			throw new IllegalStateException(
					"Input file with extention .txt or .tsv was not "
							+ "found among: " + fileList);
		return inputFile;
	}

}
