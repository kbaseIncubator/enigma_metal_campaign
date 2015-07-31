#include <KBaseFeatureValues.spec>


module KBaseEnigmaTest {


	typedef string time_unit;
	typedef string concentration_unit;


	  /*//////////////////////////////
	 //////////   Wells   ///////////
	//////////////////////////////*/

    /*
      @optional description elevation
    */
	typedef structure {
		float lat;
		float lon;
		float elevation;
		string description;
	} Location;

	/*
		@optional cluster_number area_code location metadata 
	*/
	typedef structure {
		string title;
		int cluster_number;
		string area_code;
		Location location;
	} WellInfo;


	/*
		@optional collection_date description well_info measurements metadata
	*/
	typedef structure {
		string sample_id;
        string sample_name;
		string collection_date;
		string description;
		string fraction;
		WellInfo well_info;
    } WellSampleMetadata;




	  /*////////////////////////////////
	 ///  Metadata for data series ////
	////////////////////////////////*/



	typedef structure {
		time_unit unit;
		list<float> time_values;
	} TimeSeriesMetadata;

	typedef structure {
		string base_media;
		string series_elem_compaund;
		concentration_unit unit;
		list<float> concentration_values;
	} ConcentrationSeriesMetadata;

	typedef structure {
		string base_media;
		string series_elem_compaund_class;
		list<string> compaund_values;
	} CompaundSeriesMetadata;

	typedef structure {
		string base_media;
		string series_elem_compaund_class;
		list<tuple<string,float>> compaund_concentration_values;
	} CompaundConcentrationSeriesMetadata;


	typedef structure {
		string base_media;
		list<string> variable_media_values;
	} MediaSeriesMetadata;

	typedef structure {
		list<string> molecule_type_values;
	} MoleculeTypeSeriesMetadata;

	typedef structure {
		string series_metadata_type;
		UnspecifiedObject series_metadata;
		list<string> elem_labels;
	} GenericSeriesMetadata;

	typedef structure {
		list<WellSampleMetadata> series_elem_sample_defs;
	} WellSampleSeriesMetadata;


	  /*////////////////////////////////
	 ///  Metadata for data series ////
	////////////////////////////////*/


	typedef structure{
		string name;
		string description;

		GenericSeriesMetadata row_metadata;
		TimeSeriesMetadata column_metadata;
		KBaseFeatureValues.FloatMatrix2D data;
	} GrowthMatrix;


	typedef structure{
		string name;
		string description;

		GenericSeriesMetadata row_metadata;
		TimeSeriesMetadata column_metadata;
		KBaseFeatureValues.FloatMatrix2D data;
	} ChromotographyMatrix;


	typedef structure{
		string name;
		string description;

		GenericSeriesMetadata row_metadata;
		WellSampleSeriesMetadata column_metadata;

		KBaseFeatureValues.FloatMatrix2D data;
	} WellSampleMatrix;

};