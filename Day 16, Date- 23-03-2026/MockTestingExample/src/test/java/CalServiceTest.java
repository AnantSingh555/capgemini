import com.cg.CalculatorService;
import com.cg.ICalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalServiceTest {
    private CalculatorService service;
    @BeforeEach
    public void init(){
        ICalculator cal= Mockito.mock(ICalculator.class);
        service = new CalculatorService(cal);
        when(cal.calculate(20,5)).thenReturn(25);
        when(cal.calculate(10,5)).thenReturn(150);
    }
    @Test
    void addServiceTest(){
        assertEquals(150, service.addService(10,5));
    }


}
