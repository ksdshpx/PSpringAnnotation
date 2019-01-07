package cn.ksdshpx.config;

import java.io.IOException;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * @author peng.x
 * @date 2019年1月7日 下午9:26:59
 */
public class MyTypeFilter implements TypeFilter {

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		String className = classMetadata.getClassName();
		System.out.println("--->" + className);
		if (className.contains("er")) {
			return true;
		}
		return false;
	}

}
