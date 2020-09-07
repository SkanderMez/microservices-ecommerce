import sys
from elasticsearch import Elasticsearch

index = sys.argv[1]
ci_cd = str(sys.argv[2])

elastic_client = Elasticsearch(hosts=["localhost"])

# Get last data
last_record_query_body ={
    "size": 1,
    "sort": {"@timestamp": "desc"},
    "query": {
        "match_all": {}
    }
}

get_build_user_query_body = {
    "query": {
        "match_phrase": {
            "message" : "build started by "
        }
    }
}


build_user_result = elastic_client.search(
    index=index,
    body=get_build_user_query_body)
build_user = build_user_result['hits']['hits'][0]['_source']['message'][0]


tmp = build_user.split()
username = tmp[4]


#Get last data id
result = elastic_client.search(
    index=index,
    body=last_record_query_body)

documentId = result['hits']['hits'][0]['_id']

add_ci_cd_body = {
    "script":{
    "source": "ctx._source.ci_cd = params.ci_cd",
    "lang": "painless",
    "params" : {
        "ci_cd": ci_cd
    }}
}

add_user_name_body = {
"script":{
    "source": "ctx._source.username = params.username",
    "lang": "painless",
    "params" : {
        "username": username
    }
}}


#adding new attribute for CI/CD
elastic_client.update(index=index , id=documentId, body=add_ci_cd_body)
elastic_client.update(index=index , id=documentId, body=add_user_name_body)

