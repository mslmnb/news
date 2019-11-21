<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <title>News Management</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>

</body>

<div id="react-app"></div>


<script src="https://cdn.jsdelivr.net/react/0.14.0-rc1/react.js"></script>
<script src="https://cdn.jsdelivr.net/react/0.14.0-rc1/react-dom.js"></script>

<script>
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8083/news/list";

    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myFunction(this.responseText);
        }
    }
    xmlhttp.open("GET", url, true);
    xmlhttp.send();

    function myFunction(response) {
        var news = JSON.parse(response);
        /*
         * Components
         */
        var NewsMenu = React.createClass({
            render: function () {
                return (
                    React.createElement('div', {className: "width20 box-col"},
                        React.createElement('ul', {className: "box"},
                            React.createElement('li', {},
                                React.createElement('a', {href: "#"}, "News List")
                            ),
                            React.createElement('li', {},
                                React.createElement('a', {href: "#"}, "Add News")
                            )
                        )
                    )
                )
            }
        })

        var NewsItem = React.createClass({
            propTypes: {
                id: React.PropTypes.number.isRequired,
                date: React.PropTypes.string.isRequired,
                title: React.PropTypes.string.isRequired,
                brief: React.PropTypes.string.isRequired,
                checked: React.PropTypes.bool.isRequired
            },
            render: function () {
                return (
                    React.createElement('div', {},
                        React.createElement('div', {className: "box-row"},
                            React.createElement('div', {className: "box width80"}, this.props.title),
                            React.createElement('div', {className: "box width20"}, this.props.date)
                        ),
                        React.createElement('div', {className: "box-row"},
                            React.createElement('div', {className: "box width80"}, this.props.brief),
                            React.createElement('div', {className: "box width20"})
                        ),
                        React.createElement('div', {className: "box-row"},
                            React.createElement('div', {className: "box width80"}, ""),
                            React.createElement('div', {className: "box width20"},
                                React.createElement('a', {href: "/news/jsp/view.jsp?id=" + this.props.id}, "view"),
                                React.createElement('a', {href: "/news/list?action=edit&id=" + this.props.id}, "edit"),
                                React.createElement('input', {type: "checkbox", name: "checked"})
                            )
                        ),
                        React.createElement('div', {className: "box-row"},
                            React.createElement('div', {className: "box width100"}, "")
                        )
                    )
                )
            }
        })

        var NewsView = React.createClass({
            propTypes: {
                news: React.PropTypes.array.isRequired
            },
            render: function () {
                var newsItemElements = news
                    .map(function (n) {
                        return React.createElement(NewsItem, n)
                    })
                return (
                    React.createElement('div', {},
                        React.createElement('h2', {}, "News Management"),
                        React.createElement('div', {className: "box-table"},
                            React.createElement(NewsMenu),
                            React.createElement('div', {className: "width80 box-col"}, newsItemElements)
                        )
                    )
                )
            }
        })
        /*
         * Entry point
         */
        ReactDOM.render(
            React.createElement(NewsView, {
                news: news   // Json data
            }),
            document.getElementById('react-app')
        )
    }
</script>
</html>
