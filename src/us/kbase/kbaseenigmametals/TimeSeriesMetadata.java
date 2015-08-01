
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
 * <p>Original spec-file type: TimeSeriesMetadata</p>
 * <pre>
 * ////////////////////////////////
 * ///  Metadata for data series ////
 * ////////////////////////////////
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "unit",
    "time_values"
})
public class TimeSeriesMetadata {

    @JsonProperty("unit")
    private String unit;
    @JsonProperty("time_values")
    private List<Double> timeValues;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public TimeSeriesMetadata withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    @JsonProperty("time_values")
    public List<Double> getTimeValues() {
        return timeValues;
    }

    @JsonProperty("time_values")
    public void setTimeValues(List<Double> timeValues) {
        this.timeValues = timeValues;
    }

    public TimeSeriesMetadata withTimeValues(List<Double> timeValues) {
        this.timeValues = timeValues;
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
        return ((((((("TimeSeriesMetadata"+" [unit=")+ unit)+", timeValues=")+ timeValues)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
