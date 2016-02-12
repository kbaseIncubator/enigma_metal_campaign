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

      @optional property_unit
    */

	typedef structure {
		string category;
		string property_name;
		string property_unit;
		string property_value;
	} PropertyValue;

    /* Metadata for data matrix

    */

	typedef structure {
		mapping<string,list<PropertyValue>> row_metadata;
		mapping<string,list<PropertyValue>> column_metadata;
		list<PropertyValue> matrix_metadata;
	} Matrix2DMetadata;
	
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
		Matrix2DMetadata metadata;
		FloatMatrix2D data;
	} DataMatrix;

    /* Growth data matrix

      @optional description
    */

	typedef structure{
		string name;
		string description;
		Matrix2DMetadata metadata;
		FloatMatrix2D data;
	} GrowthMatrix;

    /* Chromatography data matrix

      @optional description
    */

	typedef structure{
		string name;
		string description;
		Matrix2DMetadata metadata;
		FloatMatrix2D data;
	} ChromatographyMatrix;

    /* Sample property data matrix

      @optional description
    */

	typedef structure{
		string name;
		string description;
		Matrix2DMetadata metadata;
		FloatMatrix2D data;
	} SamplePropertyMatrix;
	
	    /* Growth data matrix

      @optional description
    */

	/*////////////////////////////////
	///   Additional data types   ////
	////////////////////////////////*/

    /* Parameters of a single growth curve

    */

	typedef structure{
    	string mtx_column_id;
    	string growth_rate;
        string lag_phase;
        string max_growth;
        string area_under_curve;
	} GrowthCurveParameters;

    /* Parameters of all growth curves for a GrowthMatrix

    */

	typedef structure{
    	string matrix_id;
    	list <GrowthCurveParameters> parameters;
	} GrowthMatrixParameters;


};
