import java.util.*;
class edges
{
    public int src,des,wt;
    public edges(int src,int des,int wt)
    {
        this.src = src;
        this.des = des;
        this.wt = wt;
    }
}
public class Bellmanford
{
    static int V,E;
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of vertices and edges:");
		V = input.nextInt();
		E = input.nextInt();
		edges Edges[] = new edges[E];
		int src,des,wt,i;
		System.out.println("Enter the corresponding source,destination and weight of edges:");
		for(i=0;i<E;i++)
		{
		    src = input.nextInt();
		    des = input.nextInt();
		    wt = input.nextInt();
		    Edges[i] = new edges(src,des,wt);
		}
		int parent[] = new int [V];
		int cost_parent[] = new int [V];
		int value[] = new int [V];
		for(i=0;i<V;i++)
		{
		    value[i] = 999;
		}
		parent[0] = -1;
		value[0] = 0;
		boolean updated=false;
		for(i=0;i<(V-1);i++)
		{
		    updated = false;
		    for(int j=0;j<E;j++)
		    {
		        int U = Edges[j].src;
		        int V = Edges[j].des;
		        int weight = Edges[j].wt;
		        if(value[U]!=999 && value[U]+weight<value[V])
			    {
				    value[V] = value[U]+weight;
				    parent[V] = U;
				    cost_parent[V] = value[V];
				    updated = true;
			    }
		    }
		    if(updated==false)
		    {
			    break;
		    }
		}
		for(int j=0;j<E && updated==true;j++)
		{
			int U = Edges[j].src;
			int V = Edges[j].des;
			int weight = Edges[j].wt;
			if(value[U]!=999 && value[U]+weight<value[V])
			{
				System.out.println("Graph has -VE edge cycle");
				return;
			}
		}
	for(i=1;i<V;i++)
		System.out.println("U->V: 0 -> " + i + "  Cost to reach from source 0 = " + value[i]);
	}
}
