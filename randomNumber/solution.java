package randomNumber;

public class solution {
	public static void main(String args[])
	{
		 int N=100,m=10,e=0,s=0;//定义要取几个不重复的随机数m,N,游标
	        int []x=new int[m];
	        while(e<m)
	        {
	            int g=(int) (Math.random()*(N+1));//随机数
	            boolean b=true;
	            for(int i=0;i<e;i++)
	            {
	                s++;
	                if(g==x[i]){b=false;break;}
	            }
	            if(b){x[e]=g;e++;}
	        }
	        //打印
	        for(int i=0;i<x.length;i++)
	            System.out.println(x[i]);
	        System.out.println("执行了"+s+"次");
	}
}
