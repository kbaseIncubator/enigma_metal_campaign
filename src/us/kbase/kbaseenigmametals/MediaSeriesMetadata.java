
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
 * <p>Original spec-file type: MediaSeriesMetadata</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "base_media",
    "variable_media_values"
})
public class MediaSeriesMetadata {

    @JsonProperty("base_media")
    private java.lang.String baseMedia;
    @JsonProperty("variable_media_values")
    private List<String> variableMediaValues;
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    @JsonProperty("base_media")
    public java.lang.String getBaseMedia() {
        return baseMedia;
    }

    @JsonProperty("base_media")
    public void setBaseMedia(java.lang.String baseMedia) {
        this.baseMedia = baseMedia;
    }

    public MediaSeriesMetadata withBaseMedia(java.lang.String baseMedia) {
        this.baseMedia = baseMedia;
        return this;
    }

    @JsonProperty("variable_media_values")
    public List<String> getVariableMediaValues() {
        return variableMediaValues;
    }

    @JsonProperty("variable_media_values")
    public void setVariableMediaValues(List<String> variableMediaValues) {
        this.variableMediaValues = variableMediaValues;
    }

    public MediaSeriesMetadata withVariableMediaValues(List<String> variableMediaValues) {
        this.variableMediaValues = variableMediaValues;
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
        return ((((((("MediaSeriesMetadata"+" [baseMedia=")+ baseMedia)+", variableMediaValues=")+ variableMediaValues)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
