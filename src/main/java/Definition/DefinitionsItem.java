package Definition;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.asif.gsonpojogenerator")
public class DefinitionsItem implements Serializable {

	@SerializedName("definition")
	private String definition;

	@SerializedName("example")
	private String example;

	public void setDefinition(String definition){
		this.definition = definition;
	}

	public String getDefinition(){
		return definition;
	}

	public void setExample(String example){
		this.example = example;
	}

	public String getExample(){
		return example;
	}
}