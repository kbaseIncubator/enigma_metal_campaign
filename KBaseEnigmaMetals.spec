/* KBase-ENIGMA data models */

module KBaseEnigmaMetals {

	typedef string date ;
	
    /* 
		An ID used for a project encompassing a piece of data at its source.
    */
    typedef string project_id;
	
    /*
		Sample ID
		@id external
	*/
    typedef string sample_id;
	
	/*
		Reference to a mapping object
		@id ws KBaseCommon.StrainInfo
	*/
    typedef string strain_ref;

    /*
		Series ID
		@id external
	*/
    typedef string series_id;
	
    /*
		Reference to a feature of a genome object
		@id subws KBaseGenomes.Genome.features.[*].id
	*/
    typedef string feature_ref;

	/*
		Reference to a mapping object
		@id ws KBaseBiochem.Media
	*/
    typedef string media_ref;
		
	/*
		Reference to a compound object
		@id subws KBaseBiochem.Biochemistry.compounds.[*].id
	*/
    typedef string compound_ref;

    /* Information about a location.
      lat - latitude of the site, recorded as a decimal number. North latitudes
          are positive values and south latitudes are negative numbers.
      lon - longitude of the site, recorded as a decimal number. West
          longitudes are positive values and east longitudes are negative
          numbers.
      elevation - elevation of the site, expressed in meters above sea level.
          Negative values are allowed.
      description - a free text description of the location and, if applicable,
          the associated event.

      @optional description elevation
    */
	typedef structure {
		float lat;
		float lon;
		float elevation;
		string description;
	} Location;

	/*
		Metadata fields
		@optional cluster_number area_code location metadata 
	*/
	typedef structure {
		string title;
		int cluster_number;
		string area_code;
		Location location;
		mapping<string, string> metadata;
	} WellInfo;
	
    /*
		Measurement data structure

		@optional parameter_unit n stddev z_score p_value median mean
	*/
    typedef structure { 
		string parameter;
		string parameter_unit;
		string unit;
        list<float> values;
        float n;
        float stddev;
		float z_score;
		float p_value;
		float median;
		float mean;
    } Measurement;

	/*
		Sample data structure
		@optional collection_date description well_info measurements metadata
	*/
	typedef structure {
		sample_id sample_id;
        string sample_name;
		date collection_date;
		project_id project_id;
		string description;
		string fraction;
		WellInfo well_info;
		list<Measurement> measurements;
		mapping<string, string> metadata;
    } WellSample;
	
	    /* 
    	ChromatographySeries subobject holds data on a single series of chromatography measurements, like absorbance
		
		level - level of fractionation 
		compound - analyzed compound
    	    	
    	@optional level compound description metadata
    	@searchable series_id level compound 
    */
    typedef structure {
		series_id series_id;
		string level;
		string compound;
		string description;
		list<Measurement> data_points;
		mapping<string, string> metadata;
    } ChromatographySeries;
	
	/* 
    	ChromatographySample object contains a set of ChromatographySeries objects

    	@optional description strains metadata
    	@searchable sample_id strains condition 
    */
    typedef structure {
		sample_id sample_id;
		string description;
		list<strain_ref> strains;
		list<ChromatographySeries> series;
		mapping<string, string> metadata;
	} ChromatographySample;

    /* 
    	GrowthSeries subobject holds data on a single series of growth data
		
		media_ref - reference to Media describing constant growth conditions
		feature_refs - list of genome features characterizing a specific genotype (optional)
		conditions - compounds that differ between series and their concentrations
		data_points - list of data points
		strains - list of strains grown
    	    	
    	@optional feature_refs
    	@searchable ws_subset series_id media_ref feature_refs conditions strains
    */
    typedef structure {
		series_id series_id;
		media_ref media_ref;
		list<feature_ref> feature_refs;
		mapping<compound_ref,string> conditions;
		list<Measurement> data_points;
		list<strain_ref> strains;
    } GrowthSeries;
	
    /* 
    	GrowthSample object contains a set of GrowthSeries objects
    	    	
    */
    typedef structure {
		sample_id sample_id;
		list<GrowthSeries> series;
	} GrowthSample;
};
