
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
 * <p>Original spec-file type: ConcentrationSeriesMetadata</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "base_media",
    "series_elem_compound",
    "unit",
    "concentration_values"
})
public class ConcentrationSeriesMetadata {

    @JsonProperty("base_media")
    private String baseMedia;
    @JsonProperty("series_elem_compound")
    private String seriesElemCompound;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("concentration_values")
    private List<Double> concentrationValues;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("base_media")
    public String getBaseMedia() {
        return baseMedia;
    }

    @JsonProperty("base_media")
    public void setBaseMedia(String baseMedia) {
        this.baseMedia = baseMedia;
    }

    public ConcentrationSeriesMetadata withBaseMedia(String baseMedia) {
        this.baseMedia = baseMedia;
        return this;
    }

    @JsonProperty("series_elem_compound")
    public String getSeriesElemCompound() {
        return seriesElemCompound;
    }

    @JsonProperty("series_elem_compound")
    public void setSeriesElemCompound(String seriesElemCompound) {
        this.seriesElemCompound = seriesElemCompound;
    }

    public ConcentrationSeriesMetadata withSeriesElemCompound(String seriesElemCompound) {
        this.seriesElemCompound = seriesElemCompound;
        return this;
    }

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ConcentrationSeriesMetadata withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    @JsonProperty("concentration_values")
    public List<Double> getConcentrationValues() {
        return concentrationValues;
    }

    @JsonProperty("concentration_values")
    public void setConcentrationValues(List<Double> concentrationValues) {
        this.concentrationValues = concentrationValues;
    }

    public ConcentrationSeriesMetadata withConcentrationValues(List<Double> concentrationValues) {
        this.concentrationValues = concentrationValues;
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
        return ((((((((((("ConcentrationSeriesMetadata"+" [baseMedia=")+ baseMedia)+", seriesElemCompound=")+ seriesElemCompound)+", unit=")+ unit)+", concentrationValues=")+ concentrationValues)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
