
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
 * <p>Original spec-file type: MoleculeTypeSeriesMetadata</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "molecule_type_values"
})
public class MoleculeTypeSeriesMetadata {

    @JsonProperty("molecule_type_values")
    private List<String> moleculeTypeValues;
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    @JsonProperty("molecule_type_values")
    public List<String> getMoleculeTypeValues() {
        return moleculeTypeValues;
    }

    @JsonProperty("molecule_type_values")
    public void setMoleculeTypeValues(List<String> moleculeTypeValues) {
        this.moleculeTypeValues = moleculeTypeValues;
    }

    public MoleculeTypeSeriesMetadata withMoleculeTypeValues(List<String> moleculeTypeValues) {
        this.moleculeTypeValues = moleculeTypeValues;
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
        return ((((("MoleculeTypeSeriesMetadata"+" [moleculeTypeValues=")+ moleculeTypeValues)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
