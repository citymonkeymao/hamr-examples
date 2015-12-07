/*
  Copyright (c) 2015, Yiju Wei. 

  HAMR is a Frame let you use annotations to describe and execute a MapReduce process.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */
package hamr.examples.maxtemprature;
import hamr.core.general.annotations.Counters;
import hamr.core.general.annotations.Generator;
import hamr.core.general.annotations.GroupField;
import hamr.core.general.annotations.ReduceField;
import hamr.core.general.annotations.SortField;
import hamr.core.general.annotations.TargetField;
import hamr.core.general.bean.AnnotedBean;
@Generator(keyGeneratorClass = TempratureKeyGenerator.class)
@Counters(counters = {MaxTempratureCounter.class})
public class TempratureBean extends AnnotedBean{
	 @SortField
	 @GroupField
     private String city;
	 
	 @ReduceField(counterClass = {MaxTempratureCounter.class})
	 private Double temprature;
	 
	 @TargetField(generateFrom = MaxTempratureCounter.class)
     private Double maxTemprature;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getTemprature() {
		return temprature;
	}
	public void setTemprature(Double temprature) {
		this.temprature = temprature;
	}
	public Double getMaxTemprature() {
		return maxTemprature;
	}
	public void setMaxTemprature(Double maxTemprature) {
		this.maxTemprature = maxTemprature;
	}
	public String toString()
	{
		return this.city + "###" + this.maxTemprature;
	}
}
