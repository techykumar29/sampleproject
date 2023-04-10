import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

/*
 * @author - prabhakar
 * */
public class Application {

	/*
	 * Print the list of odd numbers using Java 8 Stream
	 * */
	public static void main(String[] args) {
		List<String> list = Arrays.asList("2","1","5","4","5");
		getOddNumList(list);
	}
	
	static void getOddNumList(List<String> list){
	 list.stream().map(wrapperFunction(num-> Integer.parseInt(num),NumberFormatException.class)).filter(num -> num % 2 != 0)
	 .collect(Collectors.toList())
	 .forEach(wrapperCheckedExceptionFuction(i -> writeToFile(i)));;
	 
	 
	}
	static void writeToFile(int i) throws IOException{
		System.out.println(i);
		throw new IOException();
	}
    static Function<String,Integer> wrapperFunction(Function<String,Integer> f){
		return t -> {
			int output = 0;
			try {
				output = f.apply(t);
			}catch(NumberFormatException ne) {
				System.err.printf("Exception occurred while parsing String (%s) into Integer\n",t);
				
			}
			return output;
		};
	}
    // Handled Unchecked Excepitons - Generic Approach
    static <T,R,E extends Exception> Function<T,R> wrapperFunction(Function<T,R> f, Class<E> exceptionClazz){
    	Objects.requireNonNull(f);
		return t -> {
			try {
				return f.apply(t);
			}catch(Exception ex) {
				try {
					E exCast = exceptionClazz.cast(ex);
					System.err.println("Exception occurred:"+exCast.getMessage());
				}catch(ClassCastException clex) {
					throw clex;
				}
				throw ex;
			}
		};
	}
    
    static <T> Consumer<T> wrapperCheckedExceptionFuction(HandleExceptionForFunction<T, Exception> data){
    	return i -> {
    		try {
    			data.apply(i);
			} catch (Exception e) {
				System.out.println("Inside Checked Exception");
				throw new RuntimeException(e);
			}
    	};
    }
}
