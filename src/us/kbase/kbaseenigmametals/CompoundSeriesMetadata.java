
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
 * <p>Original spec-file type: CompoundSeriesMetadata</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "base_media",
    "series_elem_compound_class",
    "compound_values"
})
public class CompoundSeriesMetadata {

    @JsonProperty("base_media")
    private java.lang.String baseMedia;
    @JsonProperty("series_elem_compound_class")
    private java.lang.String seriesElemCompoundClass;
    @JsonProperty("compound_values")
    private List<String> compoundValues;
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    @JsonProperty("base_media")
    public java.lang.String getBaseMedia() {
        return baseMedia;
    }

    @JsonProperty("base_media")
    public void setBaseMedia(java.lang.String baseMedia) {
        this.baseMedia = baseMedia;
    }

    public CompoundSeriesMetadata withBaseMedia(java.lang.String baseMedia) {
        this.baseMedia = baseMedia;
        return this;
    }

    @JsonProperty("series_elem_compound_class")
    public java.lang.String getSeriesElemCompoundClass() {
        return seriesElemCompoundClass;
    }

    @JsonProperty("series_elem_compound_class")
    public void setSeriesElemCompoundClass(java.lang.String seriesElemCompoundClass) {
        this.seriesElemCompoundClass = seriesElemCompoundClass;
    }

    public CompoundSeriesMetadata withSeriesElemCompoundClass(java.lang.String seriesElemCompoundClass) {
        this.seriesElemCompoundClass = seriesElemCompoundClass;
        return this;
    }

    @JsonProperty("compound_values")
    public List<String> getCompoundValues() {
        return compoundValues;
    }

    @JsonProperty("compound_values")
    public void setCompoundValues(List<String> compoundValues) {
        this.compoundValues = compoundValues;
    }

    public CompoundSeriesMetadata withCompoundValues(List<String> compoundValues) {
        this.compoundValues = compoundValues;
        return this;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public java.lang.String toString() {
        return ((((((((("CompoundSeriesMetadata"+" [baseMedia=")+ baseMedia)+", seriesElemCompoundClass=")+ seriesElemCompoundClass)+", compoundValues=")+ compoundValues)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
