package com.boavista.step;

import com.boavista.model.Bill;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

public class ReaderBill {

    public static FlatFileItemReader<Bill> reader(String path) {
        FlatFileItemReader<Bill> reader = new FlatFileItemReader<Bill>();

        reader.setResource(new ClassPathResource(path));
        reader.setLineMapper(new DefaultLineMapper<Bill>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] {"id","tubeassemblyid", "componentid1", "quantity1", "componentid2", "quantity2", "componentid3", "quantity3", "componentid4", "quantity4", "componentid5", "quantity5", "componentid6", "quantity6", "componentid7", "quantity7", "componentid8", "quantity8" });
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Bill>() {
                    {
                        setTargetType(Bill.class);
                    }
                });
            }
        });
        return reader;
    }
    
}
