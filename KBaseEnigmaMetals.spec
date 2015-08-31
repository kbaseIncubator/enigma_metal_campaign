module KBaseEnigmaMetals {


    typedef structure {
        list<string> row_ids;
        list<string> col_ids;
        list<list<float>> values;
    } FloatMatrix2D;


	/*////////////////////////////////
	///         Metadata          ////
	////////////////////////////////*/


	typedef structure {
		string type;
		string name;
		string value_unit;
		float value;
	} MetadataItem;

	typedef structure {
		string description;
		list<tuple<string,MetadataItem>> row_metadata;
		list<tuple<string,MetadataItem>> column_metadata;
		mapping<string,string> series_properties;
	} SeriesMetadata;
	
	/*////////////////////////////////
	///         Data series       ////
	////////////////////////////////*/


	typedef structure{
		string name;
		string type;
		string description;
		SeriesMetadata metadata;
		FloatMatrix2D data;
	} DataMatrix;

	typedef structure{
		string name;
		string description;
		SeriesMetadata metadata;
		FloatMatrix2D data;
	} GrowthMatrix;


	typedef structure{
		string name;
		string description;
		SeriesMetadata metadata;
		FloatMatrix2D data;
	} ChromotographyMatrix;


	typedef structure{
		string name;
		string description;
		SeriesMetadata metadata;
		FloatMatrix2D data;
	} WellSampleMatrix;
};
