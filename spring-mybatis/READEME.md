### Installation
- Download library from [Github Migrations](https://github.com/mybatis/migrations/releases)

- Extract the distribution archive, i.e. mybatis-{project.version}.migrations.zip to the directory you wish to install MyBatis Migrations. `$HOME/Desktop/lib/migration`.
- Add MIGRATIONS environment variable to your path, e.g. add following line to `~/.bash_profile`:
`export PATH="$HOME/Desktop/lib/migration/bin:$PATH"`.

__Test Installation:__
Open a termial and run the command `migrate`, if __help__ information is showing, means installation is successful.

### Init
> This part is only needed for a brand new project

- Open a terminal, go the directory you wish to initialize migration for the project, usually, it's `migration` folder under __Project Home__ folder
- Run the command `migrate init`, it should show something like:

```
$ migrate init
OpenJDK 64-Bit Server VM warning: ignoring option PermSize=128m; support was removed in 8.0
------------------------------------------------------------------------
-- MyBatis Migrations - init
------------------------------------------------------------------------
Initializing: .
Creating: environments
Creating: scripts
Creating: drivers
Creating: README
Creating: development.properties
Creating: bootstrap.sql
Creating: 20190314220252_create_changelog.sql
Creating: 20190314220253_first_migration.sql
Done!

------------------------------------------------------------------------
-- MyBatis Migrations SUCCESS
-- Total time: 2s
-- Finished at: Fri Mar 15 11:02:53 NZDT 2019
-- Final Memory: 5M/479M
------------------------------------------------------------------------
```
- Edit `environments/development.properties`, add information for `driver`, `url`, `username`, `password`, set `send_full_script` to __false__
```
## JDBC connection properties.
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/app?characterEncoding=utf8&charaterSetResults=utf8&useSSL=false
username=root
password=
```
- By default, the name of table to record migrations is `CHANGELOG`, we can change `changelog` to `migration` in `development.properties` to rename the table name.
- Place 