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

import hamr.core.general.bean.AnnotedBean;
import hamr.core.general.keyGenerator.KeyGenerator;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.mapreduce.Mapper.Context;

public class IpKeyGenerator extends KeyGenerator {

	@SuppressWarnings("rawtypes")
	public IpKeyGenerator(Context context) {
		super(context);
	}

	public List<AnnotedBean> generate(Object keyin, Object valuein) {
		List<AnnotedBean> ret = new ArrayList<AnnotedBean>();
		String[] vals = valuein.toString().split("###");
		IpCountBean bean = new IpCountBean();
		bean.setUrl(vals[1]);
		bean.setIp(vals[0]);
		ret.add(bean);
		return ret;
	}
}
