package Translation;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.asif.gsonpojogenerator")
public class SynItem implements Serializable {

	@SerializedName("gen")
	private String gen;

	@SerializedName("pos")
	private String pos;

	@SerializedName("text")
	private String text;

	public void setGen(String gen){
		this.gen = gen;
	}

	public String getGen(){
		return gen;
	}

	public void setPos(String pos){
		this.pos = pos;
	}

	public String getPos(){
		return pos;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"SynItem{" + 
			"gen = '" + gen + '\'' + 
			",pos = '" + pos + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}