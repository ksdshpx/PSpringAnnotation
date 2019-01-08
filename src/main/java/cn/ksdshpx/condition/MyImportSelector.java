package cn.ksdshpx.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author peng.x
 * @date 2019年1月8日 上午11:11:13
 */
public class MyImportSelector implements ImportSelector {

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"cn.ksdshpx.beans.Yellow","cn.ksdshpx.beans.Blue"};
	}

}
