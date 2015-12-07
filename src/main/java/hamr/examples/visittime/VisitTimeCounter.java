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

import org.apache.hadoop.mapreduce.Reducer.Context;

import hamr.core.general.bean.AnnotedBean;
import hamr.core.general.counter.Counter;

public class VisitTimeCounter extends Counter {
	private Long firstTime;
	private Long lastTime;

	@SuppressWarnings("rawtypes")
	public VisitTimeCounter(Context context) {
		super(context);
	}

	@Override
	public void count(AnnotedBean ab) {
		Long time = ((VisitBean) ab).getMessageTime();
		if (firstTime == null) {
			firstTime = time;
		}
		lastTime = time;
	}

	@Override
	public boolean end(AnnotedBean ret) {
		if (firstTime != null && lastTime != null) {
			((VisitBean) ret).setTotalTime(lastTime - firstTime);
			return true;
		} else {
			return false;
		}
	}
}
