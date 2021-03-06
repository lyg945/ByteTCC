/**
 * Copyright 2014-2016 yangming.liu<bytefox@126.com>.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, see <http://www.gnu.org/licenses/>.
 */
package org.bytesoft.bytetcc.supports.dubbo.validator;

import org.bytesoft.bytetcc.supports.dubbo.DubboConfigValidator;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;

public class ProtocolConfigValidator implements DubboConfigValidator {

	private BeanDefinition beanDefinition;

	public void validate() throws BeansException {
		MutablePropertyValues mpv = this.beanDefinition.getPropertyValues();
		PropertyValue pv = mpv.getPropertyValue("port");
		Object value = pv == null ? null : pv.getValue();
		if (pv == null || value == null) {
			throw new FatalBeanException(
					"The value of the attribute 'port' (<dubbo:protocol port='...' />) must be explicitly specified.");
		} else if ("-1".equals(value)) {
			throw new FatalBeanException(
					"The value of the attribute 'port' (<dubbo:protocol port='...' />) must be explicitly specified and not equal to -1.");
		}
	}

	public BeanDefinition getBeanDefinition() {
		return beanDefinition;
	}

	public void setBeanDefinition(BeanDefinition beanDefinition) {
		this.beanDefinition = beanDefinition;
	}

}
