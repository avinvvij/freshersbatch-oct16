package com.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class StreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Transaction> transactionlist = TestData.getAllTransactions();
		List<News> newslist = TestData.getAllNews();
		List<Fruit> fruitlist = TestData.getAllFruits();
		Predicate<Fruit> p = (Fruit f)->f.getCalories()<100;
		Consumer<Fruit> c = (Fruit f)->{System.out.println(f);};
		System.out.println("Assignment1");
		fruitlist.stream().filter(p).sorted(Comparator.comparing(Fruit::getCalories).reversed()).forEach(c);
		
		System.out.println("Assignment2");
		
		//Map<String,List<Fruit>> colormap =  fruitlist.stream()
		//.collect(Collectors.toMap(Fruit::getColor,(Fruit f)->{return f;}));
		
		Map<String , List<Fruit>> fmap = 
		 fruitlist.stream().collect(Collectors.groupingBy(Fruit::getColor));
		
		fmap.entrySet().stream()
		.forEach((Entry<String , List<Fruit>> e)->{
			e.getValue().stream().forEach((Fruit f)->System.out.println(f));
		});
		
		
		//assignment3
		System.out.println("Assignment3");
		p = (Fruit f)->{if(f.getColor().equals("Red"))return true ; else return false;};
		fruitlist.stream().filter(p).sorted(Comparator.comparing(Fruit::getPrice)).forEach(c);
		
		
		//assignment4
		System.out.println("Assignment4");
		
		Map<Integer , Long> nmap =newslist.stream()
		.collect(Collectors.groupingBy(News::getNewsId,Collectors.counting()));
		
		Optional<Long> lng = nmap.entrySet().stream()
		.map((Entry<Integer,Long> e)->e.getValue())
		.reduce(Long::max);
		
		nmap.entrySet().stream()
		.filter((Entry<Integer,Long> e)->e.getValue()==lng.get())
		.forEach((Entry<Integer,Long> e)->{System.out.println(e.getKey());});
		
		//assignment5
		System.out.println("Assignment5");
		newslist.stream().filter((News n)->n.getComment().contains("budget")).map(News::getComment);
		
		
		//assignment6
		System.out.println("Assignment6");
		
		
		//assignment7
		System.out.println("Assignment7");
		transactionlist.stream().filter((Transaction t)->t.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).forEach((Transaction t)->System.out.println(t));
		
		//assignment8
		System.out.println("Assignment8");
		transactionlist.stream().map(Transaction::getTrader)
		.map(Trader::getCity)
		.distinct()
		.forEach((String s)->System.out.println(s));
		
		//assignment9
		System.out.println("assignment9");
		transactionlist.stream()
		.map(Transaction::getTrader)
		.filter((Trader t)->t.getCity()
				.equals("Pune"))
		.sorted(Comparator.comparing(Trader::getName).reversed())
		.forEach((Trader t)->System.out.println(t));
	
		//assignment10
		System.out.println("assignment10");
		System.out.println(transactionlist.stream()
				.map(Transaction::getTrader)
				.sorted(Comparator.comparing(Trader::getName))
				.map(Trader::getName)
				.collect(Collectors.joining(" ")));
		
		//assignment11
		System.out.println("assignment11");
		
		Long val = transactionlist.stream()
		.map(Transaction::getTrader)
		.filter((Trader t)->t.getCity().equals("Indore"))
		.collect(Collectors.counting());
		System.out.println("Number of traders in indore: "+val);
		
		//assignment12
		System.out.println("assignment12");
		transactionlist.stream()
				.filter((Transaction t)->t.getTrader().getCity().equals("Pune"))
				.forEach((Transaction t)->System.out.println(t.getValue()));
		
		//assignment13
		System.out.println("Assignment13");
		Optional<Integer> o=transactionlist.stream()
		.map(Transaction::getValue)
		.reduce(Integer::max);
		System.out.println("max value: "+o.get());
		
		
		//assignment14
		System.out.println("Assignment14");
		Optional<Integer> minval = transactionlist.stream()
				.map(Transaction::getValue)
				.reduce(Integer::min);
		
		transactionlist.stream().filter((Transaction t)->t.getValue()==minval.get()).forEach((Transaction t)->System.out.println(t));
	
		
		
		//assignment15
		System.out.println("Assignment15");
		Map<String, Long> nmapn = 
		//Optional<Long> ol =
		newslist.stream()
		.collect(Collectors.groupingBy(News::getCommentByUser , Collectors.counting()));
		
		Optional<Long> ol=
		nmapn
		.entrySet()
		.stream()
		.map((Entry<String,Long> e)->e.getValue())
		.reduce(Long::max);
		
		nmapn
		.entrySet()
		.stream()
		.filter((Entry<String,Long> e)->e.getValue()==ol.get())
		.forEach(System.out::println);
		
	}

}
