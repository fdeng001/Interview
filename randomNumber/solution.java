package randomNumber;

public class solution {
	public static void main(String args[])
	{
		 int N=100,m=10,e=0,s=0;//����Ҫȡ�������ظ��������m,N,�α�
	        int []x=new int[m];
	        while(e<m)
	        {
	            int g=(int) (Math.random()*(N+1));//�����
	            boolean b=true;
	            for(int i=0;i<e;i++)
	            {
	                s++;
	                if(g==x[i]){b=false;break;}
	            }
	            if(b){x[e]=g;e++;}
	        }
	        //��ӡ
	        for(int i=0;i<x.length;i++)
	            System.out.println(x[i]);
	        System.out.println("ִ����"+s+"��");
	}
}
