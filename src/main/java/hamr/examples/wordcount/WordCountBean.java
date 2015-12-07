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
package hamr.examples.wordcount;

import hamr.core.general.annotations.Counters;
import hamr.core.general.annotations.Generator;
import hamr.core.general.annotations.GroupField;
import hamr.core.general.annotations.SkipIO;
import hamr.core.general.annotations.SortField;
import hamr.core.general.annotations.TargetField;
import hamr.core.general.bean.AnnotedBean;
import hamr.core.general.counter.SumCounter;
@Counters(counters = {SumCounter.class})
@Generator(keyGeneratorClass = WordKeyGenerator.class)
public class WordCountBean extends AnnotedBean{
	@GroupField
	@SortField
	public String word;
	
	@SkipIO
	@TargetField(generateFrom = SumCounter.class)
	private Integer count;
	
	public String toString()
	{
		return word + "###" + count;
	}
}
