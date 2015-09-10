
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
 * <p>Original spec-file type: SeriesMetadata</p>
 * <pre>
 * Metadata for data matrix
 *       @optional description series_properties
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "description",
    "row_metadata",
    "column_metadata",
    "series_properties"
})
public class SeriesMetadata {

    @JsonProperty("description")
    private java.lang.String description;
    @JsonProperty("row_metadata")
    private List<us.kbase.common.service.Tuple2 <String, us.kbase.kbaseenigmametals.MetadataItem>> rowMetadata;
    @JsonProperty("column_metadata")
    private List<us.kbase.common.service.Tuple2 <String, us.kbase.kbaseenigmametals.MetadataItem>> columnMetadata;
    @JsonProperty("series_properties")
    private Map<String, String> seriesProperties;
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    @JsonProperty("description")
    public java.lang.String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public SeriesMetadata withDescription(java.lang.String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("row_metadata")
    public List<us.kbase.common.service.Tuple2 <String, us.kbase.kbaseenigmametals.MetadataItem>> getRowMetadata() {
        return rowMetadata;
    }

    @JsonProperty("row_metadata")
    public void setRowMetadata(List<us.kbase.common.service.Tuple2 <String, us.kbase.kbaseenigmametals.MetadataItem>> rowMetadata) {
        this.rowMetadata = rowMetadata;
    }

    public SeriesMetadata withRowMetadata(List<us.kbase.common.service.Tuple2 <String, us.kbase.kbaseenigmametals.MetadataItem>> rowMetadata) {
        this.rowMetadata = rowMetadata;
        return this;
    }

    @JsonProperty("column_metadata")
    public List<us.kbase.common.service.Tuple2 <String, us.kbase.kbaseenigmametals.MetadataItem>> getColumnMetadata() {
        return columnMetadata;
    }

    @JsonProperty("column_metadata")
    public void setColumnMetadata(List<us.kbase.common.service.Tuple2 <String, us.kbase.kbaseenigmametals.MetadataItem>> columnMetadata) {
        this.columnMetadata = columnMetadata;
    }

    public SeriesMetadata withColumnMetadata(List<us.kbase.common.service.Tuple2 <String, us.kbase.kbaseenigmametals.MetadataItem>> columnMetadata) {
        this.columnMetadata = columnMetadata;
        return this;
    }

    @JsonProperty("series_properties")
    public Map<String, String> getSeriesProperties() {
        return seriesProperties;
    }

    @JsonProperty("series_properties")
    public void setSeriesProperties(Map<String, String> seriesProperties) {
        this.seriesProperties = seriesProperties;
    }

    public SeriesMetadata withSeriesProperties(Map<String, String> seriesProperties) {
        this.seriesProperties = seriesProperties;
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
        return ((((((((((("SeriesMetadata"+" [description=")+ description)+", rowMetadata=")+ rowMetadata)+", columnMetadata=")+ columnMetadata)+", seriesProperties=")+ seriesProperties)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
