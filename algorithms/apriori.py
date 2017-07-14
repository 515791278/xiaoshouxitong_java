from numpy import *

from production.sql import querySql
from sql import *
c=querySql()


def createC1(dataSet):
    C1 = []
    for transaction in dataSet:
        for item in transaction:
            if not [item] in C1:
                C1.append([item])

    C1.sort()
    return map(frozenset, C1) 

def scanD(D,Ck,minSupport):
    ssCnt={}
    for tid in D:
        for can in Ck:
            if can.issubset(tid):
                if can not in ssCnt.keys():
                    ssCnt[can] = 1
                else:
                    ssCnt[can] += 1
    num=float(len(D))
    retList=[]
    supportData={}
    for key in ssCnt:
        support=ssCnt[key]/num
        if support >=minSupport:
            retList.insert(0,key)#返回值
        supportData[key]=support#返回支持度和值
    return retList,supportData

c1=list(createC1(c))
# # print(len(list(c1)))
D=list(c)

# print(L1)
def aprioriGen(Lk,k):
    retlist=[]
    lenLk=len(Lk)
    for i in range(lenLk):
        for j  in range(i+1,lenLk):
            L1 = list(Lk[i])[:k - 2]
            # print("L1   ",L1)
            L2 = list(Lk[j])[:k - 2]
            L1.sort()
            L2.sort()
            if L1 == L2:  # if first k-2 elements are equal
                retlist.append(Lk[i] | Lk[j])  # set union
    return retlist

def apriori(dataSet,min=0.3):
    c1=list(createC1(dataSet))
    D=dataSet
    L1,supp=scanD(D,c1,min)
    L=[L1]
    # print(L)[[frozenset({'7'}), frozenset({'9'}), frozenset({'8'})]]
    k=2
    while(len(L[k-2])>0):
        Ck=aprioriGen(L[k-2],k)
        Lk,supK=scanD(D,Ck,min)
        supp.update(supK)
        L.append(Lk)
        k+=1
    return L,supp
L1,supp=apriori(D,0.1)
print(L1)

def generateRules(L, supportData, minConf=0.7):  #L是列表，SU，字典
    bigRuleList = []
    for i in range(1, len(L)):#only get the sets with two or more items
        for freqSet in L[i]:#在频繁集
            H1 = [frozenset([item]) for item in freqSet] #单个集合中所有单个
            if (i > 1):
                rulesFromConseq(freqSet, H1, supportData, bigRuleList, minConf)
            else:
                calcConf(freqSet, H1, supportData, bigRuleList, minConf)

def calcConf(freqSet, H, supportData, brl, minConf=0.7):
    prunedH = [] #create new list to return
    for conseq in H:
        conf = supportData[freqSet]/supportData[freqSet-conseq] #calc confidence
        if conf >= minConf:
            print (freqSet-conseq,'-->',conseq,'conf:',conf)
            brl.append((freqSet-conseq, conseq, conf))
            prunedH.append(conseq)
    return prunedH

def rulesFromConseq(freqSet, H, supportData, brl, minConf=0.7):
    m = len(H[0])
    if (len(freqSet) > (m + 1)): #try further merging
        Hmp1 = aprioriGen(H, m+1)#create Hm+1 new candidates
        print("rules      ....")
        Hmp1 = calcConf(freqSet, Hmp1, supportData, brl, minConf)
        if (len(Hmp1) > 1):    #need at least two sets to merge
            rulesFromConseq(freqSet, Hmp1, supportData, brl, minConf)
L,sup=apriori(c,0.3)
rule=generateRules(L,sup,0.3)
print(rule)
print(L)