// Cpp implementation of Kosaraju's
// first we traverse and then invert graph and compute scc
#include <bits/stdc++.h>
#include <iostream>
#include <string>
using namespace std;

const int MAX = 100000;
vector<int> adj[MAX];
vector<int> adjInv[MAX];
bool visited[MAX];
bool visitedInv[MAX];
stack<int> s;

int scc[MAX];
int counter = 1;

void addEdges(int a, int b)
{
    adj[a].push_back(b);
}

void addEdgesInverse(int a, int b)
{
    adjInv[b].push_back(a);
}

void dfsFirst(int u)
{
    if(visited[u])
        return;

    visited[u] = 1;

    for (int i=0;i<adj[u].size();i++)
        dfsFirst(adj[u][i]);

    s.push(u);
}

void dfsSecond(int u)
{
    if(visitedInv[u])
        return;

    visitedInv[u] = 1;

    for (int i=0;i<adjInv[u].size();i++)
        dfsSecond(adjInv[u][i]);

    scc[u] = counter;
}

void is2Satisfiable(int n, int m, int a[], int b[])
{
    for(int i=0;i<m;i++)
    {
        if (a[i]>0 && b[i]>0)
        {
            addEdges(a[i]+n, b[i]);
            addEdgesInverse(a[i]+n, b[i]);
            addEdges(b[i]+n, a[i]);
            addEdgesInverse(b[i]+n, a[i]);
        }
        else if (a[i]>0 && b[i]<0)
        {
            addEdges(a[i]+n, n-b[i]);
            addEdgesInverse(a[i]+n, n-b[i]);
            addEdges(-b[i], a[i]);
            addEdgesInverse(-b[i], a[i]);
        }
        else if (a[i]<0 && b[i]>0)
        {
            addEdges(-a[i], b[i]);
            addEdgesInverse(-a[i], b[i]);
            addEdges(b[i]+n, n-a[i]);
            addEdgesInverse(b[i]+n, n-a[i]);
        }
        else
        {
            addEdges(-a[i], n-b[i]);
            addEdgesInverse(-a[i], n-b[i]);
            addEdges(-b[i], n-a[i]);
            addEdgesInverse(-b[i], n-a[i]);
        }
    }
    for (int i=1;i<=2*n;i++)
        if (!visited[i])
            dfsFirst(i);
    while (!s.empty())
    {
        int n = s.top();
        s.pop();

        if (!visitedInv[n])
        {
            dfsSecond(n);
            counter++;
        }
    }

    for (int i=1;i<=n;i++)
    {
        if(scc[i]==scc[i+n])
        {
            cout << "false" << endl;
            return;
        }
    }
    cout << "true" << endl;
    return;
}
int main()
{
    string firstLine;
    getline (cin, firstLine);
    int slash_index = firstLine.find(" ");
    int m = std::stoi(firstLine.substr(0, slash_index));
    int n = std::stoi(firstLine.substr(slash_index + 1, firstLine.length()));
    //cout << n << " " << m << "\n";

    int a[m];
    int b[m];
    for (int i = 0; i < m; i++) {
        string line;
        getline (cin, line);
        int slash_index = line.find(" ");
        a[i] = std::stoi(line.substr(0, slash_index));
        b[i] = std::stoi(line.substr(slash_index + 1, line.length()));
    }
    is2Satisfiable(n, m, a, b);
    return 0;
}