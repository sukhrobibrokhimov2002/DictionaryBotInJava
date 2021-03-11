package Translation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.asif.gsonpojogenerator")
public class TrItem implements Serializable {

	@SerializedName("gen")
	private String gen;

	@SerializedName("ex")
	private List<ExItem> ex;

	@SerializedName("pos")
	private String pos;

	@SerializedName("mean")
	private List<MeanItem> mean;

	@SerializedName("syn")
	private List<SynItem> syn;

	@SerializedName("text")
	private String text;

	public void setGen(String gen){
		this.gen = gen;
	}

	public String getGen(){
		return gen;
	}

	public void setEx(List<ExItem> ex){
		this.ex = ex;
	}

	public List<ExItem> getEx(){
		return ex;
	}

	public void setPos(String pos){
		this.pos = pos;
	}

	public String getPos(){
		return pos;
	}

	public void setMean(List<MeanItem> mean){
		this.mean = mean;
	}

	public List<MeanItem> getMean(){
		return mean;
	}

	public void setSyn(List<SynItem> syn){
		this.syn = syn;
	}

	public List<SynItem> getSyn(){
		return syn;
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
			"TrItem{" + 
			"gen = '" + gen + '\'' + 
			",ex = '" + ex + '\'' + 
			",pos = '" + pos + '\'' + 
			",mean = '" + mean + '\'' + 
			",syn = '" + syn + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}