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

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.mapreduce.Mapper.Context;

import hamr.core.general.bean.AnnotedBean;
import hamr.core.general.keyGenerator.KeyGenerator;

public class TempratureKeyGenerator extends KeyGenerator{

	@SuppressWarnings("rawtypes")
	public TempratureKeyGenerator(Context context) {
		super(context);
	}
	public List<AnnotedBean> generate(Object keyin , Object valuein)
	{
		List<AnnotedBean> ret = new ArrayList<AnnotedBean>();
		String[] vals = valuein.toString().split("###");
		TempratureBean bean = new TempratureBean();
		bean.setCity(vals[0]);
		bean.setTemprature(Double.valueOf(vals[2]));
		ret.add(bean);
		return ret;
	}
}
