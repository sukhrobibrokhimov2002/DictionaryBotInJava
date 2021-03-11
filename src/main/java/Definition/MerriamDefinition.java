package Definition;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.asif.gsonpojogenerator")
public class MerriamDefinition implements Serializable {

	@SerializedName("phonetics")
	private List<PhoneticsItem> phonetics;

	@SerializedName("word")
	private String word;

	@SerializedName("meanings")
	private List<MeaningsItem> meanings;

	public void setPhonetics(List<PhoneticsItem> phonetics){
		this.phonetics = phonetics;
	}

	public List<PhoneticsItem> getPhonetics(){
		return phonetics;
	}

	public void setWord(String word){
		this.word = word;
	}

	public String getWord(){
		return word;
	}

	public void setMeanings(List<MeaningsItem> meanings){
		this.meanings = meanings;
	}

	public List<MeaningsItem> getMeanings(){
		return meanings;
	}


}