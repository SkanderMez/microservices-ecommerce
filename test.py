from elasticsearch import Elasticsearch
import sys
index = sys.argv[1]
ci_cd = str(sys.argv[2])

elastic_client = Elasticsearch(hosts=["localhost"])

# Get last data
query_body ={
    "size": 1,
    "sort": {"@timestamp": "desc"},
    "query": {
        "match_all": {}
    }
}

#Get last data id
result = elastic_client.search(
    index=index,
    body=query_body)
print ( "message  : ")
print (result['hits']['hits'][0]['_source']['message'])
print ( "id  : ")
documentId = result['hits']['hits'][0]['_id']
print (documentId)


#adding new attribute for CI/CD
r = elastic_client.update(index=index , id=documentId, body={"script":{
    "source": "ctx._source.ci_cd = params.ci_cd",
    "lang": "painless",
    "params" : {
        "ci_cd": ci_cd
    }
}
})
