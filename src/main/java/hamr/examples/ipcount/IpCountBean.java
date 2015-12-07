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
package hamr.examples.ipcount;

import hamr.core.general.annotations.Counters;
import hamr.core.general.annotations.Generator;
import hamr.core.general.annotations.GroupField;
import hamr.core.general.annotations.ReduceField;
import hamr.core.general.annotations.SkipIO;
import hamr.core.general.annotations.SortField;
import hamr.core.general.annotations.TargetField;
import hamr.core.general.bean.AnnotedBean;
import hamr.core.general.counter.SetSumCounter;
@Generator(keyGeneratorClass = IpKeyGenerator.class)
@Counters(counters = {SetSumCounter.class})
public class IpCountBean extends AnnotedBean{
	@SortField
	@GroupField
	private String url;
	@ReduceField(counterClass = {SetSumCounter.class})
	private String ip;
	@SkipIO
	@TargetField(generateFrom = SetSumCounter.class , fromField = "ip")
	private Integer ipNum;
    
	public String toString()
	{
		return url + "###" + ipNum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getIpNum() {
		return ipNum;
	}

	public void setIpNum(Integer ipNum) {
		this.ipNum = ipNum;
	}
}
