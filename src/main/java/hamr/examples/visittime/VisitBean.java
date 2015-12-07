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
package hamr.examples.visittime;

import hamr.core.general.annotations.Counters;
import hamr.core.general.annotations.Generator;
import hamr.core.general.annotations.GroupField;
import hamr.core.general.annotations.SkipIO;
import hamr.core.general.annotations.SortField;
import hamr.core.general.bean.AnnotedBean;

@Generator(keyGeneratorClass = VisitKeyGenerator.class)
@Counters(counters = { VisitTimeCounter.class })
public class VisitBean extends AnnotedBean {

	@SortField(level = 3)
	@GroupField
	private String url;
	
	@SortField(level = 2)
	@GroupField
	private String SessionId;

	@SortField(level = 1)
	private Long messageTime;

	@SkipIO
	private Long totalTime;

	public String getSessionId() {
		return SessionId;
	}

	public void setSessionId(String sessionId) {
		SessionId = sessionId;
	}

	public Long getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Long messageTime) {
		this.messageTime = messageTime;
	}

	public Long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Long totalTime) {
		this.totalTime = totalTime;
	}

	public String toString() {
		return this.url+ "###" + this.SessionId + "###" + this.totalTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
