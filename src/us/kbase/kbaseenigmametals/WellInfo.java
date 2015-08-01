
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
 * <p>Original spec-file type: WellInfo</p>
 * <pre>
 * @optional cluster_number area_code location
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "title",
    "cluster_number",
    "area_code",
    "location"
})
public class WellInfo {

    @JsonProperty("title")
    private String title;
    @JsonProperty("cluster_number")
    private Long clusterNumber;
    @JsonProperty("area_code")
    private String areaCode;
    /**
     * <p>Original spec-file type: Location</p>
     * <pre>
     * @optional description elevation
     * </pre>
     * 
     */
    @JsonProperty("location")
    private Location location;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public WellInfo withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("cluster_number")
    public Long getClusterNumber() {
        return clusterNumber;
    }

    @JsonProperty("cluster_number")
    public void setClusterNumber(Long clusterNumber) {
        this.clusterNumber = clusterNumber;
    }

    public WellInfo withClusterNumber(Long clusterNumber) {
        this.clusterNumber = clusterNumber;
        return this;
    }

    @JsonProperty("area_code")
    public String getAreaCode() {
        return areaCode;
    }

    @JsonProperty("area_code")
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public WellInfo withAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    /**
     * <p>Original spec-file type: Location</p>
     * <pre>
     * @optional description elevation
     * </pre>
     * 
     */
    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    /**
     * <p>Original spec-file type: Location</p>
     * <pre>
     * @optional description elevation
     * </pre>
     * 
     */
    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    public WellInfo withLocation(Location location) {
        this.location = location;
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
        return ((((((((((("WellInfo"+" [title=")+ title)+", clusterNumber=")+ clusterNumber)+", areaCode=")+ areaCode)+", location=")+ location)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
