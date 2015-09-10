
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
 * <p>Original spec-file type: MetadataItem</p>
 * <pre>
 * Single piece of metadata
 *       @optional value_unit value
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "type",
    "name",
    "value_unit",
    "value"
})
public class MetadataItem {

    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("value_unit")
    private String valueUnit;
    @JsonProperty("value")
    private Double value;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public MetadataItem withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public MetadataItem withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("value_unit")
    public String getValueUnit() {
        return valueUnit;
    }

    @JsonProperty("value_unit")
    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    public MetadataItem withValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
        return this;
    }

    @JsonProperty("value")
    public Double getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Double value) {
        this.value = value;
    }

    public MetadataItem withValue(Double value) {
        this.value = value;
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
        return ((((((((((("MetadataItem"+" [type=")+ type)+", name=")+ name)+", valueUnit=")+ valueUnit)+", value=")+ value)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
