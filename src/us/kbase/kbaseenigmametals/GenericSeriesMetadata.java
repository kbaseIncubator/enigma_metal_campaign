
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
import us.kbase.common.service.UObject;


/**
 * <p>Original spec-file type: GenericSeriesMetadata</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "series_metadata_type",
    "series_metadata",
    "elem_labels"
})
public class GenericSeriesMetadata {

    @JsonProperty("series_metadata_type")
    private java.lang.String seriesMetadataType;
    @JsonProperty("series_metadata")
    private UObject seriesMetadata;
    @JsonProperty("elem_labels")
    private List<String> elemLabels;
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    @JsonProperty("series_metadata_type")
    public java.lang.String getSeriesMetadataType() {
        return seriesMetadataType;
    }

    @JsonProperty("series_metadata_type")
    public void setSeriesMetadataType(java.lang.String seriesMetadataType) {
        this.seriesMetadataType = seriesMetadataType;
    }

    public GenericSeriesMetadata withSeriesMetadataType(java.lang.String seriesMetadataType) {
        this.seriesMetadataType = seriesMetadataType;
        return this;
    }

    @JsonProperty("series_metadata")
    public UObject getSeriesMetadata() {
        return seriesMetadata;
    }

    @JsonProperty("series_metadata")
    public void setSeriesMetadata(UObject seriesMetadata) {
        this.seriesMetadata = seriesMetadata;
    }

    public GenericSeriesMetadata withSeriesMetadata(UObject seriesMetadata) {
        this.seriesMetadata = seriesMetadata;
        return this;
    }

    @JsonProperty("elem_labels")
    public List<String> getElemLabels() {
        return elemLabels;
    }

    @JsonProperty("elem_labels")
    public void setElemLabels(List<String> elemLabels) {
        this.elemLabels = elemLabels;
    }

    public GenericSeriesMetadata withElemLabels(List<String> elemLabels) {
        this.elemLabels = elemLabels;
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
        return ((((((((("GenericSeriesMetadata"+" [seriesMetadataType=")+ seriesMetadataType)+", seriesMetadata=")+ seriesMetadata)+", elemLabels=")+ elemLabels)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
