
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
 * <p>Original spec-file type: WellSampleMetadata</p>
 * <pre>
 * @optional sample_name collection_date description well_info fraction
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "sample_id",
    "sample_name",
    "collection_date",
    "description",
    "fraction",
    "well_info"
})
public class WellSampleMetadata {

    @JsonProperty("sample_id")
    private String sampleId;
    @JsonProperty("sample_name")
    private String sampleName;
    @JsonProperty("collection_date")
    private String collectionDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("fraction")
    private String fraction;
    /**
     * <p>Original spec-file type: WellInfo</p>
     * <pre>
     * @optional cluster_number area_code location
     * </pre>
     * 
     */
    @JsonProperty("well_info")
    private WellInfo wellInfo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sample_id")
    public String getSampleId() {
        return sampleId;
    }

    @JsonProperty("sample_id")
    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public WellSampleMetadata withSampleId(String sampleId) {
        this.sampleId = sampleId;
        return this;
    }

    @JsonProperty("sample_name")
    public String getSampleName() {
        return sampleName;
    }

    @JsonProperty("sample_name")
    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public WellSampleMetadata withSampleName(String sampleName) {
        this.sampleName = sampleName;
        return this;
    }

    @JsonProperty("collection_date")
    public String getCollectionDate() {
        return collectionDate;
    }

    @JsonProperty("collection_date")
    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public WellSampleMetadata withCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
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

    public WellSampleMetadata withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("fraction")
    public String getFraction() {
        return fraction;
    }

    @JsonProperty("fraction")
    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public WellSampleMetadata withFraction(String fraction) {
        this.fraction = fraction;
        return this;
    }

    /**
     * <p>Original spec-file type: WellInfo</p>
     * <pre>
     * @optional cluster_number area_code location
     * </pre>
     * 
     */
    @JsonProperty("well_info")
    public WellInfo getWellInfo() {
        return wellInfo;
    }

    /**
     * <p>Original spec-file type: WellInfo</p>
     * <pre>
     * @optional cluster_number area_code location
     * </pre>
     * 
     */
    @JsonProperty("well_info")
    public void setWellInfo(WellInfo wellInfo) {
        this.wellInfo = wellInfo;
    }

    public WellSampleMetadata withWellInfo(WellInfo wellInfo) {
        this.wellInfo = wellInfo;
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
        return ((((((((((((((("WellSampleMetadata"+" [sampleId=")+ sampleId)+", sampleName=")+ sampleName)+", collectionDate=")+ collectionDate)+", description=")+ description)+", fraction=")+ fraction)+", wellInfo=")+ wellInfo)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
