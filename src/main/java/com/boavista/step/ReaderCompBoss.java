package com.boavista.step;

import com.boavista.model.CompBoss;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

public class ReaderCompBoss {

    public static FlatFileItemReader<CompBoss> reader(String path) {
        FlatFileItemReader<CompBoss> reader = new FlatFileItemReader<CompBoss>();

        reader.setResource(new ClassPathResource(path));
        reader.setLineMapper(new DefaultLineMapper<CompBoss>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] {"id","component_type_id","type","connection_type_id","outside_shape","base_type","height_over_tube","bolt_pattern_long","bolt_pattern_wide","groove","base_diameter","shoulder_diameter","unique_feature","orientation","weight"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<CompBoss>() {
                    {
                        setTargetType(CompBoss.class);
                    }
                });
            }
        });
        return reader;
    }

}
