function Root() {
    return (
        <div className="row">
            <Stats/>
        </div>
    );
}

class Stats extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            statistic: []
        };
    }

    componentDidMount() {
        fetch("stats/data")
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        isLoaded: true,
                        statistic: result
                    });
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )
    }

    render() {
        const {error, isLoaded, statistic} = this.state;
        console.log(statistic);
        if (error) {
            return <div>Ошибка: {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Загрузка...</div>;
        } else {
            return (
                <div>
                    <h1>Создано аккаунтов - {statistic.accountsCreated}</h1>
                    <h1>Создано постов    - {statistic.postsCreated}</h1>
                    <h1>Добавлено друзей  - {statistic.friendsAdded}</h1>
                </div>
            );
        }
    }
}

ReactDOM.render(
    <Root/>,
    document.getElementById('root')
);