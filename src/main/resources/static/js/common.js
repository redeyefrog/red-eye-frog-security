function ajax(method, url, params, fn) {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if( this.readyState === 4 ) {
			if( this.status === 200 ) {
				fn(this.responseText);
			} else {
				console.log('Error Message: ' + this.status + ' ' + this.statusText);
			}
		}
	};
	xhr.open(method, url, true);
	xhr.setRequestHeader('content-type','application/json; charset=utf-8');
	xhr.send(params);
}

function formSubmit(url, params) {
	let form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", url);
	form.setAttribute("accept-charset", "UTF-8");
	for( let key in params ) {
		if( params.hasOwnProperty(key) ) {
			let hiddenField = document.createElement("input");
			hiddenField.setAttribute("type", "hidden");
			hiddenField.setAttribute("name", key);
			hiddenField.setAttribute("value", params[key]);

			form.appendChild(hiddenField);
		 }
	}
	document.body.appendChild(form);
	form.submit();
}

function getParams() {
    let data = {};
    let elms = document.getElementsByTagName('input');
    for( let i in elms ) {
        if( elms.hasOwnProperty(i) ) {
            let elm = elms[i];

            let type = elm.getAttribute('type');
            if( type === 'text' || type === 'hidden' ) {
                data[elm.getAttribute('name')] = elm.value;
            }
        }
    }
    return data;
}

function isNull(arg) {
	if( typeof(arg) === 'undefined' || arg === '' || arg === null ) {
		return true;
	} else {
		return false;
	}
}
