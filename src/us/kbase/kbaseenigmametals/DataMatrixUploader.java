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
import us.kbase.kbaseenigmametals.FloatMatrix2D;
import us.kbase.kbaseenigmametals.DataMatrix;

public class DataMatrixUploader {

	protected static final String GROWTH_EXTERNAL_TYPE = "tsv.growth";
	protected static final String CHROMATOGRAPHY_EXTERNAL_TYPE = "tsv.chromatography";
	protected static final String WELLS_EXTERNAL_TYPE = "tsv.wells";
	
	static Options options = new Options();

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		DataMatrixUploader uploader = new DataMatrixUploader();
		uploader.upload(args);
	}

	public DataMatrixUploader() {


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

		OptionBuilder.withLongOpt("external_type");
		OptionBuilder.withDescription("External type");
		OptionBuilder.hasArg(true);
		OptionBuilder.withArgName("external_type");
		options.addOption(OptionBuilder.create("et"));

	}
/*
	private static WorkspaceClient getWsClient(String wsUrl, AuthToken token)
			throws Exception {
		WorkspaceClient wsClient = new WorkspaceClient(new URL(wsUrl), token);
		wsClient.setAuthAllowedForHttp(true);
		return wsClient;
	}
*/
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

/*					AuthToken token = null;
					String user = System.getProperty("test.user");
					String pwd = System.getProperty("test.pwd");
					String tokenString = System.getenv("KB_AUTH_TOKEN");
					token = tokenString == null ? AuthService.login(user, pwd)
							.getToken() : new AuthToken(tokenString);
*/
							

					File inputFile = findTabFile(new File(
							line.getOptionValue("id")));

					String externalType = line.getOptionValue("et");
					DataMatrix matrix = new DataMatrix();
					matrix.setName(line.getOptionValue("on"));
					
					if (externalType.equalsIgnoreCase(GROWTH_EXTERNAL_TYPE)) {
						matrix = generateGrowthMatrix(inputFile, matrix);
					} else if (externalType.equalsIgnoreCase(CHROMATOGRAPHY_EXTERNAL_TYPE)){
						//TODO
					} else if (externalType.equalsIgnoreCase(WELLS_EXTERNAL_TYPE)){
						//TODO
					} else {
						System.err.println("Unknown external type " + externalType);
						System.exit(1);
					};

					

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

/*					WorkspaceClient cl = getWsClient(line.getOptionValue("ws"),
							token);
					List<ObjectSaveData> saveData = new ArrayList<ObjectSaveData>();
					saveData.add(new ObjectSaveData()
							.withData(
									UObject.transformObjectToObject(matrix,
											UObject.class))
							.withType("KBaseEnigmaMetals.GrowthMatrix")
							.withName(line.getOptionValue("on"))
							.withMeta(new HashMap<String, String>()));
					SaveObjectsParams params = new SaveObjectsParams()
							.withWorkspace(line.getOptionValue("wn"))
							.withObjects(saveData);

					cl.saveObjects(params);
*/
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

	public DataMatrix generateGrowthMatrix(File inputFile, DataMatrix matrix)
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
				} else if (line.matches("DATA\t\t.*")) {
					dataFlag = true;
					colMetaDataFlag = false;
					rowMetaDataFlag = false;
				} else if (line.matches("COL_METADATA\t\t.*")) {
					dataFlag = false;
					colMetaDataFlag = true;
					rowMetaDataFlag = false;
				} else if (line.matches("ROW_METADATA\t\t.*")) {
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
					;
				}
				;

			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		matrix.setData(parseData(data));
		matrix.setMetadata(parseMetadata(columnMetaData, rowMetaData, matrix.getData().getColIds(), matrix.getData().getRowIds()));
		
		
		if (matrix.getMetadata().getSeriesProperties().containsKey("Description")) {
			matrix.setDescription(matrix.getMetadata().getSeriesProperties().get("Description"));
		} else {
			matrix.setDescription("");
		}


		return matrix;
	}

	protected static FloatMatrix2D parseData(List<String> data) {
		List<List<Double>> dataValues = new ArrayList<List<Double>>();
		Long samplesNumber = 0L;
		List<String> sampleNames = new ArrayList<String>();
		List<String> rowNames = new ArrayList<String>();
		FloatMatrix2D floatMatrix = new FloatMatrix2D();

		for (String line : data) {
			if (line.matches("DATA\t.*")) {
				String[] fields = line.split("\t");
				for (int i = 1; i < fields.length; i++) {
					if (!fields[i].equals("")){
						sampleNames.add(fields[i]);
						samplesNumber ++;
					};
						//System.out.println(fields[i]);
				};
				/*
				 * for (Integer i = 0; i < samplesNumber; i++) { HashMap<String,
				 * Double> dataValue = new HashMap<String, Double>();
				 * dataValues.add(dataValue); }
				 */
			} else {
				// System.out.println(samplesNumber);
				// System.out.println(line);
				String[] fields = line.split("\t", -1);
				rowNames.add(fields[0]);

				List<Double> rowValues = new ArrayList<Double>();
				// System.out.println(fields.length);
				Integer j = 0;
				while (j < samplesNumber) {
					try {
						Double value = Double.valueOf(fields[j + 1]);
						rowValues.add(value);
					} catch (NumberFormatException e) {
						rowValues.add(0.00);
						System.out.println("WARNING: unsuccessful conversion of metadata value " + fields[4] + " in line " + line);
					}
					// System.out.println(fields[0]+" "+fields[j+1]);
					j++;
				}
				dataValues.add(rowValues);
			}
		}
		floatMatrix.setValues(dataValues);
		floatMatrix.setRowIds(rowNames);
		floatMatrix.setColIds(sampleNames);

		return floatMatrix;

	};

	protected static SeriesMetadata parseMetadata (List<String> columnMetaData, List<String> rowMetaData, List<String> sampleNames, List<String> rowNames) {
		SeriesMetadata returnVal = new SeriesMetadata();
		
		List<Tuple2<String, MetadataItem>> columnMetaDataItems = new ArrayList<Tuple2<String, MetadataItem>>();
		List<Tuple2<String, MetadataItem>> rowMetaDataItems = new ArrayList<Tuple2<String, MetadataItem>>();
		Map<String, String> seriesProperties = new HashMap<String, String>();
		
		for (String line : columnMetaData) {
			if (line.equals("")) {
				// do nothing on blank lines
			} else {
				String[] fields = line.split("\t");
				if (fields[0].equals("")) {
					// process series-specific fields
					seriesProperties.put(fields[1], fields[2]);
				} else if (sampleNames.contains(fields[0])) {
					// process sample-specific fields
					MetadataItem item = new MetadataItem();
					if (fields.length==5) {
						item.setType(fields[1]);
						item.setName(fields[2]);
						item.setValueUnit(fields[3]);
						try {
							Double value = Double.valueOf(fields[4]);
							item.setValue(value);
						} catch (NumberFormatException e) {
							item.setValue(0.00);
							System.out.println("WARNING: unsuccessful conversion of metadata value " + fields[4] + " in line " + line);
						}
					} else {
						item.setType(fields[1]);
						item.setName(fields[2]);
						item.setValueUnit("");
						item.setValue(0.00);
					}
					Tuple2<String, MetadataItem> itemTuple = new Tuple2<String, MetadataItem>().withE1(fields[0]).withE2(item);
					columnMetaDataItems.add(itemTuple);
				} else {
					System.err.println("Unknown column label in line " + line);
				}
			}
		}

		for (String line : rowMetaData) {
			if (line.equals("")) {
				// do nothing on blank lines
			} else {
				String[] fields = line.split("\t");
				if (fields[0].equals("")) {
					// process series-specific fields
					seriesProperties.put(fields[1], fields[2]);
				} else if (rowNames.contains(fields[0])) {
					// process sample-specific fields
					MetadataItem item = new MetadataItem();
					if (fields.length==5) {
						item.setType(fields[1]);
						item.setName(fields[2]);
						item.setValueUnit(fields[3]);
						try {
							Double value = Double.valueOf(fields[4]);
							item.setValue(value);
						} catch (NumberFormatException e) {
							item.setValue(0.00);
							System.out.println("WARNING: unsuccessful conversion of metadata value " + fields[4] + " in line " + line);
							System.out.println("Zero value is set for " + fields[1] + ":" + fields[2] + " in sample " + fields[0]);
						}
					} else {
						item.setType(fields[1]);
						item.setName(fields[2]);
						item.setValueUnit("");
						item.setValue(0.00);
					}
					Tuple2<String, MetadataItem> itemTuple = new Tuple2<String, MetadataItem>().withE1(fields[0]).withE2(item);
					rowMetaDataItems.add(itemTuple);
				} else {
					System.err.println("Unknown row label in line " + line);
				}
			}
		}
		
		returnVal.setColumnMetadata(columnMetaDataItems);
		returnVal.setRowMetadata(rowMetaDataItems);
		returnVal.setSeriesProperties(seriesProperties);
		
		return returnVal;
	};
	
/*	private GrowthMatrix parseMetaData(List<String> metaData,
			GrowthMatrix matrix) {

		String timeUnit = "Unspecified";
		String baseMedia = "Unspecified";
		String concentrationUnit = "Unspecified";
		String element = "Unspecified";
		String description = "Unspecified";

		List<Double> concentrationValues = new ArrayList<Double>();
		List<Double> timeValues = new ArrayList<Double>();
		List<String> elemLabels = new ArrayList<String>();

		List<String> sampleNames = matrix.getData().getColIds();
		List<String> rowNames = matrix.getData().getRowIds();

		for (String line : metaData) {
			if (line.equals("")) {
				// do nothing on blank lines
			} else {
				String[] fields = line.split("\t");
				if (fields[0].equals("")) {
					// process series-specific fields
					if ((fields[1].equals("Time unit"))
							|| (fields[1].equals("time unit"))) {
						timeUnit = fields[2];
					} else if ((fields[1].equals("Base medium"))
							|| (fields[1].equals("base medium"))
							|| (fields[1].equals("Medium"))
							|| (fields[1].equals("medium"))) {
						baseMedia = fields[2];
					} else if ((fields[1].equals("Concentration unit"))
							|| (fields[1].equals("concentration unit"))) {
						concentrationUnit = fields[2];
					} else if ((fields[1].equals("Substance"))
							|| (fields[1].equals("substance"))
							|| (fields[1].equals("Compound"))
							|| (fields[1].equals("compound"))) {
						element = fields[2];
					} else if ((fields[1].equals("Description"))
							|| (fields[1].equals("description"))) {
						description = fields[2];
					} else {
						System.out.println("Unknown parameter " + fields[1]
								+ " in line " + line);
					}
				} else if (sampleNames.contains(fields[0])) {
					// process sample-specific fields
					if ((fields[1].equals("Concentration"))
							|| (fields[1].equals("concentration"))) {
						concentrationValues.add(Double.valueOf(fields[2]));
						elemLabels.add(fields[0]);
					} else {
						System.err.println("Unknown parameter " + fields[1]
								+ " in line " + line);
					}
				} else {
					System.err.println("Unknown sample label in line " + line);
				}
			}
		}

		for (String value : rowNames) {
			timeValues.add(Double.valueOf(value.split(":", -1)[0]));
		}

		TimeSeriesMetadata timeSeriesMetadata = new TimeSeriesMetadata()
				.withTimeValues(timeValues).withUnit(timeUnit);

		ConcentrationSeriesMetadata concentrationSeriesMetadata = new ConcentrationSeriesMetadata()
				.withBaseMedia(baseMedia).withSeriesElemCompound(element)
				.withUnit(concentrationUnit)
				.withConcentrationValues(concentrationValues);

		GenericSeriesMetadata genericSeriesMetadata = new GenericSeriesMetadata()
				.withSeriesMetadataType("ConcentrationSeriesMetadata")
				.withElemLabels(elemLabels)
				.withSeriesMetadata(
						UObject.transformObjectToObject(
								concentrationSeriesMetadata, UObject.class));

		matrix.setRowMetadata(genericSeriesMetadata);
		matrix.setColumnMetadata(timeSeriesMetadata);
		matrix.setDescription(description);

		return matrix;
	}
*/
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

		if (!line.hasOption("wd")) {
			System.err.println("External type required (for example, TSV.Growth)");
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
