import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JunitTest {
    public static void main(String[] args) {
        Object o = new Object();
    }


    /**
     * 行为验证 相关
     */
    @Test
    public void test1() {
        final List mockList = Mockito.mock(List.class);
        mockList.add("mock1");
        mockList.get(0);
        mockList.size();
        mockList.clear();
        // 验证方法被使用（默认1次）
        Mockito.verify(mockList).add("mock1");

        // 验证方法被使用1次
        Mockito.verify(mockList, Mockito.times(1)).get(0);

        // 验证方法至少被使用1次
        Mockito.verify(mockList, Mockito.atLeast(1)).size();

        // 验证方法没有被使用
        Mockito.verify(mockList, Mockito.never()).contains("mock2");

        // 验证方法至多被使用5次
        Mockito.verify(mockList, Mockito.atMost(5)).clear();

        // 指定方法调用超时时间
        Mockito.verify(mockList, timeout(100)).get(0);

        // 指定时间内需要完成的次数
        Mockito.verify(mockList, timeout(200).atLeastOnce()).size();
    }

    /**
     * 如何做一些测试桩stub
     */
    @Test
    public void test2() {
        //静态导入，减少代码量：
         import static org.mockito.Mockito .*;
        final ArrayList mockList = mock(ArrayList.class);
        // 设置方法调用返回值
        when(mockList.add("test2")).thenReturn(true);
        doReturn(true).when(mockList).add("test2");
        System.out.println(mockList.add("test2"));  //true
        // 设置方法调用抛出异常
        when(mockList.get(0)).thenThrow(new RuntimeException());
        doThrow(new RuntimeException()).when(mockList).get(0);
        System.out.println(mockList.get(0));
        throw RuntimeException
        // 无返回方法打桩
        doNothing().when(mockList).clear();
        // 为回调做测试桩（对方法返回进行拦截处理）
        final Answer<String> answer = new Answer<String>() {
            // @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                final List mock = (List) invocationOnMock.getMock();
                return "mock.size result => " + mock.size();
            }
        };
        when(mockList.get(1)).thenAnswer(answer);
        doAnswer(answer).when(mockList).get(1);
        System.out.println(mockList.get(1));
        mock.size result =>0
        // 对同一方法多次打桩，以最后一次为准
        when(mockList.get(2)).thenReturn("test2_1");
        when(mockList.get(2)).thenReturn("test2_2");
        System.out.println(mockList.get(2));    //test2_2
        System.out.println(mockList.get(2));    //test2_2
        // 设置多次调用同类型结果
        when(mockList.get(3)).thenReturn("test2_1", "test2_2");
        when(mockList.get(3)).thenReturn("test2_1").thenReturn("test2_2");
        System.out.println(mockList.get(3));    //test2_1
        System.out.println(mockList.get(3));    //test2_2
        // 为连续调用做测试桩（为同一个函数调用的不同的返回值或异常做测试桩）
        when(mockList.get(4)).thenReturn("test2").thenThrow(new RuntimeException());
        doReturn("test2").doThrow(new RuntimeException()).when(mockList).get(4);
        System.out.println(mockList.get(4));    //test2
        System.out.println(mockList.get(4));    //throw RuntimeException
        // 无打桩方法，返回默认值
        System.out.println(mockList.get(99));
//         null
    }

    /**
     * 参数匹配器 支持
     */
    @Test
    public void test3() {
        final Map mockMap = mock(Map.class);
        // 正常打桩测试
        when(mockMap.get("key")).thenReturn("value1");
        System.out.println(mockMap.get("key"));     //value1
        // 为灵活起见，可使用参数匹配器
        when(mockMap.get(anyString())).thenReturn("value2");
        System.out.println(mockMap.get(anyString()));   //value2
        System.out.println(mockMap.get("test_key"));    //value2
        System.out.println(mockMap.get(0)); //null
        // 多个入参时，要么都使用参数匹配器，要么都不使用，否则会异常
        when(mockMap.put(anyString(), anyInt())).thenReturn("value3");
        System.out.println(mockMap.put("key3", 3));     //value3
        System.out.println(mockMap.put(anyString(), anyInt()));     //value3
        System.out.println(mockMap.put("key3", anyInt()));    //异常
        // 行为验证时，也支持使用参数匹配器
        verify(mockMap, atLeastOnce()).get(anyString());
        verify(mockMap).put(anyString(), eq(3));
        // 自定义参数匹配器
        final ArgumentMatcher<ArgumentTestRequest> myArgumentMatcher = new ArgumentMatcher<ArgumentTestRequest>() {
            @Override
            public boolean matches(ArgumentTestRequest request) {
                return "name".equals(request.getName())
                        || "value".equals(request.getValue());
            }
        };
        // 自定义参数匹配器使用
        final ArgumentTestService mock = mock(ArgumentTestService.class);
        when(mock.argumentTestMethod(argThat(myArgumentMatcher))).thenReturn("success");
        doReturn("success").when(mock).argumentTestMethod(argThat(myArgumentMatcher));
        System.out.println(mock.argumentTestMethod(new ArgumentTestRequest("name", "value")));  // success
        System.out.println(mock.argumentTestMethod(new ArgumentTestRequest()));
        // null
    }


    /**
     * 验证交互顺序
     */
    @Test
    public void test4() {
        // 验证同一个对象多个方法的执行顺序
         final List mockList = mock(List.class);
         mockList.add("first");
         mockList.add("second");
         final InOrder inOrder = inOrder(mockList);
         inOrder.verify(mockList).add("first");
         inOrder.verify(mockList).add("second");
        // 验证多个对象多个方法的执行顺序
         final List mockList1 = mock(List.class);
         final List mockList2 = mock(List.class);
         mockList1.get(0);
         mockList1.get(1);
         mockList2.get(0);
         mockList1.get(2);
         mockList2.get(1);
         final InOrder inOrder1 = inOrder(mockList1, mockList2);
         inOrder1.verify(mockList1).get(0);
         inOrder1.verify(mockList1).get(2);
         inOrder1.verify(mockList2).get(1);
         }
    }

