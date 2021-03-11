package Definition;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.asif.gsonpojogenerator")
public class MeaningsItem implements Serializable {

	@SerializedName("partOfSpeech")
	private String partOfSpeech;

	@SerializedName("definitions")
	private List<DefinitionsItem> definitions;

	public void setPartOfSpeech(String partOfSpeech){
		this.partOfSpeech = partOfSpeech;
	}

	public String getPartOfSpeech(){
		return partOfSpeech;
	}

	public void setDefinitions(List<DefinitionsItem> definitions){
		this.definitions = definitions;
	}

	public List<DefinitionsItem> getDefinitions(){
		return definitions;
	}
}