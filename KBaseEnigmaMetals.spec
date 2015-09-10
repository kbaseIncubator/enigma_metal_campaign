module KBaseEnigmaMetals {


    typedef structure {
        list<string> row_ids;
        list<string> col_ids;
        list<list<float>> values;
    } FloatMatrix2D;


	/*////////////////////////////////
	///         Metadata          ////
	////////////////////////////////*/

    /* Single piece of metadata

      @optional value_unit value
    */

	typedef structure {
		string type;
		string name;
		string value_unit;
		float value;
	} MetadataItem;

    /* Metadata for data matrix

      @optional description series_properties
    */

	typedef structure {
		string description;
		list<tuple<string,MetadataItem>> row_metadata;
		list<tuple<string,MetadataItem>> column_metadata;
		mapping<string,string> series_properties;
	} SeriesMetadata;
	
	/*////////////////////////////////
	///         Data series       ////
	////////////////////////////////*/

    /* Generic data matrix

      @optional description type
    */

	typedef structure{
		string name;
		string type;
		string description;
		SeriesMetadata metadata;
		FloatMatrix2D data;
	} DataMatrix;

    /* Growth data matrix

      @optional description
    */

	typedef structure{
		string name;
		string description;
		SeriesMetadata metadata;
		FloatMatrix2D data;
	} GrowthMatrix;

    /* Chromatography data matrix

      @optional description
    */

	typedef structure{
		string name;
		string description;
		SeriesMetadata metadata;
		FloatMatrix2D data;
	} ChromatographyMatrix;

    /* Well sample data matrix

      @optional description
    */

	typedef structure{
		string name;
		string description;
		SeriesMetadata metadata;
		FloatMatrix2D data;
	} WellSampleMatrix;
};
