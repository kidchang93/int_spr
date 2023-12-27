package org.zerock.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
//@Primary // 얘를 우선으로
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAO {
}
