
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
 * <p>Original spec-file type: ChromatographyMatrix</p>
 * <pre>
 * Chromatography data matrix
 *       @optional description
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "description",
    "metadata",
    "data"
})
public class ChromatographyMatrix {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    /**
     * <p>Original spec-file type: SeriesMetadata</p>
     * <pre>
     * Metadata for data matrix
     *       @optional description series_properties
     * </pre>
     * 
     */
    @JsonProperty("metadata")
    private SeriesMetadata metadata;
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

    public ChromatographyMatrix withName(String name) {
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

    public ChromatographyMatrix withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * <p>Original spec-file type: SeriesMetadata</p>
     * <pre>
     * Metadata for data matrix
     *       @optional description series_properties
     * </pre>
     * 
     */
    @JsonProperty("metadata")
    public SeriesMetadata getMetadata() {
        return metadata;
    }

    /**
     * <p>Original spec-file type: SeriesMetadata</p>
     * <pre>
     * Metadata for data matrix
     *       @optional description series_properties
     * </pre>
     * 
     */
    @JsonProperty("metadata")
    public void setMetadata(SeriesMetadata metadata) {
        this.metadata = metadata;
    }

    public ChromatographyMatrix withMetadata(SeriesMetadata metadata) {
        this.metadata = metadata;
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

    public ChromatographyMatrix withData(FloatMatrix2D data) {
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
        return ((((((((((("ChromatographyMatrix"+" [name=")+ name)+", description=")+ description)+", metadata=")+ metadata)+", data=")+ data)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
