
package us.kbase.kbaseenigmametals;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * <p>Original spec-file type: ChromotographyMatrix</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "description",
    "row_metadata",
    "column_metadata",
    "data"
})
public class ChromotographyMatrix {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    /**
     * <p>Original spec-file type: GenericSeriesMetadata</p>
     * 
     * 
     */
    @JsonProperty("row_metadata")
    private GenericSeriesMetadata rowMetadata;
    /**
     * <p>Original spec-file type: TimeSeriesMetadata</p>
     * <pre>
     * ////////////////////////////////
     * ///  Metadata for data series ////
     * ////////////////////////////////
     * </pre>
     * 
     */
    @JsonProperty("column_metadata")
    private TimeSeriesMetadata columnMetadata;
    /**
     * <p>Original spec-file type: FloatMatrix2D</p>
     * 
     * 
     */
    @JsonProperty("data")
    private FloatMatrix2D data;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public ChromotographyMatrix withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public ChromotographyMatrix withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * <p>Original spec-file type: GenericSeriesMetadata</p>
     * 
     * 
     */
    @JsonProperty("row_metadata")
    public GenericSeriesMetadata getRowMetadata() {
        return rowMetadata;
    }

    /**
     * <p>Original spec-file type: GenericSeriesMetadata</p>
     * 
     * 
     */
    @JsonProperty("row_metadata")
    public void setRowMetadata(GenericSeriesMetadata rowMetadata) {
        this.rowMetadata = rowMetadata;
    }

    public ChromotographyMatrix withRowMetadata(GenericSeriesMetadata rowMetadata) {
        this.rowMetadata = rowMetadata;
        return this;
    }

    /**
     * <p>Original spec-file type: TimeSeriesMetadata</p>
     * <pre>
     * ////////////////////////////////
     * ///  Metadata for data series ////
     * ////////////////////////////////
     * </pre>
     * 
     */
    @JsonProperty("column_metadata")
    public TimeSeriesMetadata getColumnMetadata() {
        return columnMetadata;
    }

    /**
     * <p>Original spec-file type: TimeSeriesMetadata</p>
     * <pre>
     * ////////////////////////////////
     * ///  Metadata for data series ////
     * ////////////////////////////////
     * </pre>
     * 
     */
    @JsonProperty("column_metadata")
    public void setColumnMetadata(TimeSeriesMetadata columnMetadata) {
        this.columnMetadata = columnMetadata;
    }

    public ChromotographyMatrix withColumnMetadata(TimeSeriesMetadata columnMetadata) {
        this.columnMetadata = columnMetadata;
        return this;
    }

    /**
     * <p>Original spec-file type: FloatMatrix2D</p>
     * 
     * 
     */
    @JsonProperty("data")
    public FloatMatrix2D getData() {
        return data;
    }

    /**
     * <p>Original spec-file type: FloatMatrix2D</p>
     * 
     * 
     */
    @JsonProperty("data")
    public void setData(FloatMatrix2D data) {
        this.data = data;
    }

    public ChromotographyMatrix withData(FloatMatrix2D data) {
        this.data = data;
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
        return ((((((((((((("ChromotographyMatrix"+" [name=")+ name)+", description=")+ description)+", rowMetadata=")+ rowMetadata)+", columnMetadata=")+ columnMetadata)+", data=")+ data)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
