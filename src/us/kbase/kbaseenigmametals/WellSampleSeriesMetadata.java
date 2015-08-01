
package us.kbase.kbaseenigmametals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * <p>Original spec-file type: WellSampleSeriesMetadata</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "series_elem_sample_defs"
})
public class WellSampleSeriesMetadata {

    @JsonProperty("series_elem_sample_defs")
    private List<WellSampleMetadata> seriesElemSampleDefs;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("series_elem_sample_defs")
    public List<WellSampleMetadata> getSeriesElemSampleDefs() {
        return seriesElemSampleDefs;
    }

    @JsonProperty("series_elem_sample_defs")
    public void setSeriesElemSampleDefs(List<WellSampleMetadata> seriesElemSampleDefs) {
        this.seriesElemSampleDefs = seriesElemSampleDefs;
    }

    public WellSampleSeriesMetadata withSeriesElemSampleDefs(List<WellSampleMetadata> seriesElemSampleDefs) {
        this.seriesElemSampleDefs = seriesElemSampleDefs;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return ((((("WellSampleSeriesMetadata"+" [seriesElemSampleDefs=")+ seriesElemSampleDefs)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
