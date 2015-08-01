package us.kbase.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import us.kbase.auth.TokenFormatException;
import us.kbase.common.service.JsonClientException;
import us.kbase.common.service.UObject;
import us.kbase.common.service.UnauthorizedException;
import us.kbase.kbaseenigmametals.CompoundSeriesMetadata;
import us.kbase.kbaseenigmametals.FloatMatrix2D;
import us.kbase.kbaseenigmametals.GenericSeriesMetadata;
import us.kbase.kbaseenigmametals.WellInfo;
import us.kbase.kbaseenigmametals.WellSampleMatrix;
import us.kbase.kbaseenigmametals.WellSampleMetadata;
import us.kbase.kbaseenigmametals.WellSampleSeriesMetadata;
import us.kbase.idserverapi.IDServerAPIClient;

public class WellsDataImporter {

	private static final String ID_SERVICE_URL = "http://kbase.us/services/idserver";

	private static IDServerAPIClient _idClient = null;

	private String fileName = null;
	private String token = null;
	private Long workspaceId = null;
	private String timeUnit = "hours";

	
	public WellsDataImporter (String fileName, Long workspaceId, String token) throws Exception{
		if (fileName == null) {
			System.out.println("cMonkey Expression data file name required");
		} else {
			this.fileName = fileName;
		}
		if (token == null) {
			throw new Exception("Token not assigned");
		} else {
			this.token = token;
		}
		
		if (workspaceId == null) {
			throw new Exception("Workspace name not assigned");
		} else {
			this.workspaceId = workspaceId;
		}

	}
	
	protected static IDServerAPIClient idClient() {
		if (_idClient == null) {
			URL idServerUrl = null;
			try {
				idServerUrl = new URL(ID_SERVICE_URL);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_idClient = new IDServerAPIClient(idServerUrl);
		}
		return _idClient;
	}
	
	public List<String> generateWellSampleMatrix(String name) throws TokenFormatException, IOException, JsonClientException {
		List<String> result = new ArrayList<String>();
		WellSampleMatrix matrix = new WellSampleMatrix();
		matrix.setName(name);
		matrix.setDescription("Adams Lab 100-well Survey Data 1-118 2013-05-16");
		
		List<String> compoundNames = new ArrayList<String>();
		List<String> rowNames = new ArrayList<String>();
		FloatMatrix2D floatMatrix = new FloatMatrix2D();
		List<List<Double>> dataValues = new ArrayList<List<Double>>();
		CompoundSeriesMetadata compoundSeriesMetadata = new CompoundSeriesMetadata().withBaseMedia("Unspecified").withSeriesElemCompoundClass("Unspecified");
		WellSampleSeriesMetadata wellSampleSeriesMetadata = new WellSampleSeriesMetadata();
		List<WellSampleMetadata> wellSampleMetadatas = new ArrayList<WellSampleMetadata>();

		Long samplesNumber = 0L;		
		try {
			String line = null;
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				if (line.equals("")) {
					// do nothing
				} else if (line.matches("Temp Number\t.*")) {
					String[] fields = line.split("\t");
					samplesNumber = fields.length - 3L;
					for (int i = 3; i < fields.length; i++) { 
						compoundNames.add(fields[i]);
						 //System.out.println(fields[i]);
					}
/*					for (Integer i = 0; i < samplesNumber; i++) {
						HashMap<String, Double> dataValue = new HashMap<String, Double>();
						dataValues.add(dataValue);
					}
*/
				} else {
					//System.out.println(samplesNumber);
					//System.out.println(line);
					String[] fields = line.split("\t", -1);
					rowNames.add(fields[0]);
					WellSampleMetadata wellSampleMetadata = new WellSampleMetadata().withSampleId(fields[1]);
					WellInfo wellInfo = new WellInfo().withTitle(fields[2]);
					wellSampleMetadata.setWellInfo(wellInfo);
					wellSampleMetadatas.add(wellSampleMetadata);
					List<Double> rowValues = new ArrayList<Double>();
					//System.out.println(fields.length);
					Integer j = 3;
					while (j < samplesNumber+3) {
						rowValues.add(parseConcentrationValue(fields[j]));
						//System.out.println(fields[0]+" "+fields[j+1]);
						j++;
					}
					dataValues.add(rowValues);
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		compoundSeriesMetadata.setCompoundValues(compoundNames);
		wellSampleSeriesMetadata.setSeriesElemSampleDefs(wellSampleMetadatas);
		floatMatrix.setValues(dataValues);
		floatMatrix.setRowIds(rowNames);
		floatMatrix.setColIds(compoundNames);
		matrix.setData(floatMatrix);

		GenericSeriesMetadata genericSeriesMetadata = new GenericSeriesMetadata().withSeriesMetadataType("CompoundSeriesMetadata").withElemLabels(compoundNames).withSeriesMetadata(UObject.transformObjectToObject(compoundSeriesMetadata, UObject.class));
		
		matrix.setColumnMetadata(wellSampleSeriesMetadata);
		matrix.setRowMetadata(genericSeriesMetadata);
		
//		System.out.println(matrix.toString());
		WsDeluxeUtil.saveObjectToWorkspaceRef(UObject.transformObjectToObject(matrix, UObject.class), "KBaseEnigmaMetals.WellSampleMatrix", workspaceId, name, "https://ci.kbase.us/services/ws", token.toString());
		
		return result;
	}
	
	public static double parseConcentrationValue (String value) {

	    Double theNumber;
	    try {
	        theNumber = Double.valueOf(value);
	        return theNumber;
	    } catch (NumberFormatException e) {
	        return Double.valueOf("0");
	    }
	}

	protected static String getKbaseId(String entityType) {
		String returnVal = null;
		try {
			if (entityType.equals("ClusterSet")) {
				returnVal = "kb|clusterSet."
						+ idClient().allocateIdRange("kb|clusterSet", 1L)
								.toString();
			} else {
				System.out.println("ID requested for unknown type "
						+ entityType);
			}
		} catch (UnauthorizedException e) {
			System.err.println("Unable to get KBase ID for " + entityType + " from " + ID_SERVICE_URL + ": Unauthorized Exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to get KBase ID for " + entityType + " from " + ID_SERVICE_URL + ": IO Exception");
			e.printStackTrace();
		} catch (JsonClientException e) {
			System.err.println("Unable to get KBase ID for " + entityType + " from " + ID_SERVICE_URL + ": Json error");
			e.printStackTrace();
		}
		return returnVal;
	}


}
